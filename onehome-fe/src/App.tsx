import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
// import Search from './components/Search';
// import PrivateRoute from './components/PrivateRoute';
// import About from './components/About.js';
import { LoginForm } from 'components/landing_page/forms/LoginForm';
import RegistrationForm from 'components/landing_page/forms/RegistrationForm';
import StyledNavbar from 'components/partials/Navbar';
import { User } from 'types/User';
import { AuthContext } from 'context/AuthContext';
import { getUserInfo } from 'services/AuthenticationService';
import Footer from 'components/partials/Footer';
import { defaultUser } from 'DefaultUser';
import RegisterShelterForm from 'components/shelter_registration/RegisterShelterForm';
import Home from 'components/Home';
import { Map } from 'Test';
import { UserContext } from 'context/UserContext';

const App = (): JSX.Element => {
  const [user, setUser] = useState<User>(defaultUser);
  const [token, setToken] = useState(localStorage.getItem('token') || '');
  const setTokens = (data: string): void => {
    localStorage.setItem('token', JSON.stringify(data));
    setToken(data);
  };
  const getLoggedInUser = async (): Promise<void> => {
    console.log(await getUserInfo());
    setUser(await getUserInfo());
  };

  useEffect(() => {
    console.log(token);
    if (token !== '') {
      getLoggedInUser();
    } else setUser(defaultUser);
  }, [token]);

  return (
    <>
      <AuthContext.Provider value={{ token, setTokens }}>
        <UserContext.Provider value={{ user, setUser }}>
          <Router>
            <StyledNavbar />
            <Route path="/" exact component={Home} />
            <LoginForm />
            {token !== '' && (
              <Route path="/login" exact component={LoginForm} />
            )}
            {token !== '' && (
              <Route path="/register" exact component={RegistrationForm} />
            )}
            <Route
              path="/registershelter"
              exact
              component={RegisterShelterForm}
            />
            <Route path="/map" exact component={Map} />
            {/* <Route path="/search" exact component={Search} />
        <Route path="/about" exact component={About} /> */}
          </Router>
        </UserContext.Provider>
      </AuthContext.Provider>
      <Footer />
    </>
  );
};

export default App;
