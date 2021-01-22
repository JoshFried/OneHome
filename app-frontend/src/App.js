import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Redirect } from "react-router-dom";
import RegistrationForm from "./components/RegistrationForm";
import LoginForm from "./components/LoginForm";
import Home from "./components/Home";
import Search from "./components/Search";
import PrivateRoute from "./components/PrivateRoute";
import About from "./components/About.js";
import StyledNavbar from "./components/Navbar.js";
import Footer from "./components/Footer.js";
import { AuthContext } from "./components/Auth";
import { useUserContext } from "./components/User";
import RegisterShelterForm from "./components/shelter_registration/RegisterShelterForm.js";
import config from "./Utils/config";
import axios from "axios";
function App() {
  const [auth, setAuth] = useState(false);
  const [user, setUser] = useState(null);
  useEffect(() => {
    axios
      .get(`${config.BACKEND_URL}/user`, { withCredentials: true })
      .then((response) => {
        setAuth(true);
        console.log(response);
        setUser(response.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <Router>
      <div>
        <StyledNavbar />
        <Route path="/" exact component={Home} />
        <Route path="/login" exact component={LoginForm} />
        <Route path="/register" exact component={RegistrationForm} />
        <Route path="/registershelter" exact component={RegisterShelterForm} />
        <Route path="/search" exact component={Search} />
        <Route path="/about" exact component={About} />
      </div>
      <Footer />
    </Router>
  );
}

export default App;
