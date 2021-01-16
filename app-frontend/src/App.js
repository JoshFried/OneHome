import React, {useState} from "react";
import {
  BrowserRouter as Router,
  Route,
} from "react-router-dom";
import Register from "./components/Register";
import Home from "./components/Home";
import PrivateRoute from "./components/PrivateRoute";
import {AuthContext} from "./components/Auth.js"
function App() {
  /*const [authTokens, setAuthTokens] = useState(localStorage.getItem("token") || "");
    const setTokens = (data) => {
    localStorage.setItem("token", JSON.stringify(data));
    setAuthTokens(data);
  }; */
  return (
    <Router>
      <div>
        <Route path = "/" exact component = {Home}/>
      </div>
    </Router>
  );
}

export default App;
