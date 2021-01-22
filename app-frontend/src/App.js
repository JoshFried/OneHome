import React from 'react';
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

function App() {
  // const [auth, setAuth] = useState(false);
  // const [user, setUser] = useState(null);
  return (
    <Router>
      <div>
        <LoginForm />
        {/* <RegistrationForm /> */}
        {/* <StyledNavbar /> */}
        {/* <Route path="/" exact component={Home} /> */}
        {/* <Route path="/login" exact component={LoginForm} /> */}
        {/* <Route path="/register" exact component={RegistrationForm} /> */}
        {/* <Route path="/registershelter" exact component={RegisterShelterForm} />
        <Route path="/search" exact component={Search} />
        <Route path="/about" exact component={About} /> */}
      </div>
      {/* <Footer /> */}
    </Router>
  );
}

export default App;
