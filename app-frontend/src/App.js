import React from "react";
import {
  BrowserRouter as Router,
  Route,
} from "react-router-dom";
import Register from "./components/Register";
import Home from "./components/Home";
import PrivateRoute from "./components/PrivateRoute";
function App() {
  return (
    <Router>
      <div>
        <Route/>
        <PrivateRoute path = '/protected' component = {Protected}/>
      </div>
    </Router>
  );
}

export default App;
