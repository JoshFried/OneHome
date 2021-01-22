import React, { useState, useEffect, Fragment } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
// import Search from './components/Search';
// import PrivateRoute from './components/PrivateRoute';
// import About from './components/About.js';
// import Footer from './components/Footer.js';
// import { AuthContext } from './components/Auth';
// import { useUserContext } from './components/User';
// import RegisterShelterForm from './components/shelter_registration/RegisterShelterForm.js';
import { LoginForm } from 'components/landing_page/forms/LoginForm';
import RegistrationForm from 'components/landing_page/forms/RegistrationForm';
import StyledNavbar from 'components/partials/Navbar';
import { User } from 'types/User';
import { AuthContext } from 'context/AuthContext';
import { getUserInfo } from 'services/AuthenticationService';

const App = (): any => {
  const [user, setUser] = useState<User>();
  const [token, setToken] = useState(localStorage.getItem('token') || '');

  const setTokens = (data: string): void => {
    localStorage.setItem('token', JSON.stringify(data));
    setToken(data);
  };

  const getLoggedInUser = async (): Promise<void> => {
    setUser(await getUserInfo());
  };

  useEffect(() => {
    if (token !== '') getLoggedInUser();
  }, [token]);

  return (
    <Fragment>
      <AuthContext.Provider value={{ token, setTokens }}>
        <Router>
          <StyledNavbar />
          {token != '' && <LoginForm />}
          {/* <RegistrationForm /> */}
          {/* <Route path="/" exact component={Home} /> */}
          {/* <Route path="/login" exact component={LoginForm} /> */}
          {/* <Route path="/register" exact component={RegistrationForm} /> */}
          {/* <Route path="/registershelter" exact component={RegisterShelterForm} />
        <Route path="/search" exact component={Search} />
        <Route path="/about" exact component={About} /> */}
        </Router>
      </AuthContext.Provider>
      {/* <Footer /> */}
    </Fragment>
  );
};

export default App;
