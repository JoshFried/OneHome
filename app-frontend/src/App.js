import React, {useState} from "react";
import {
  BrowserRouter as Router,
  Route,
} from "react-router-dom";
import RegistrationForm from "./components/RegistrationForm";
import LoginForm from "./components/LoginForm";
import Home from "./components/Home";
import Search from "./components/Search";
import PrivateRoute from "./components/PrivateRoute";
import {AuthContext} from "./components/Auth.js"
function App() {
  const [authTokens, setAuthTokens] = useState(localStorage.getItem("token") || "");
    const setTokens = (data) => {
    localStorage.setItem("token", JSON.stringify(data));
    setAuthTokens(data);
  }; 
  return (
    <Router>
      <div>
        <Route path = "/" exact component = {Home}/>
        <Route path = "/login" exact component = {LoginForm}/>
        <Route path = "/register" exact component = {RegistrationForm}/>
        <Route path = "/search" exact component = {Search}/>
      </div>
    </Router>
  );
}

export default App;
