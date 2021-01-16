import React, { useState, useEffect, useMemo } from "react";
import { BrowserRouter as Router, Redirect, Route, Switch } from "react-router-dom";
import LoginForm from "./components/LoginForm";
import RegistrationForm from "./components/RegistrationForm";
import Home from "./components/Home";
import Navbar from "./components/Navbar"
import PrivateRoute from "./components/PrivateRoute";
import {AuthContext} from "./components/Auth.js"
function App() {
  const [authTokens, setAuthTokens] = useState(
    localStorage.getItem("token") || "");
  const setTokens = (data) => {
  localStorage.setItem("token", JSON.stringify(data));
  setAuthTokens(data);
  };
  const [user, setUser] = useState(null);
  return (
     <AuthContext.Provider value={{ authTokens, setAuthTokens: setTokens }}>
            <Router>
              <div>
                <Navbar authTokens={authTokens} />
                <Switch>
                  <Route exact path="/" render={() => user ?  <Redirect to="/profile" /> : <Redirect to="/login" />} />
                  <Route path="/register" render={() => user ? <Redirect to="/" /> : < RegistrationForm />} />
                  <Route path="/login" render={() => user ? <Redirect to="/" /> : <LoginForm />} />
                </Switch>
              </div>
            </Router>

    </AuthContext.Provider>
  );
}

export default App;
