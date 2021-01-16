import React, { useState } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "./Auth";
import Axios from "axios";
import "../Utils/config";
import { useUser } from "./UserContext";

const Navbar = (props) => {
  const [selectedTab, setSelectedTab] = React.useState(0);

  const handleChange = (event, newValue) => {
    setSelectedTab(newValue);
  };

  //const { user, setUser } = useUser();

  /*const [authTokens, setAuthTokens] = useState(
    localStorage.getItem("token") || ""
  );*/
  const [authTokens, setAuthTokens] = useState(
    true
  );

  const setTokens = (data) => {
    localStorage.setItem("token", JSON.stringify(data));
    setAuthTokens(data);
  };

  /*const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem('summerStart');
    localStorage.removeItem('summerEnd');
    localStorage.removeItem('winterStart');
    localStorage.removeItem('winterEnd');
    setUser(null);
    Axios.get(global.config.BACKEND_URL + `/logout`);
  }; */

  return (
    <AuthContext.Provider value={{ authTokens, setAuthTokens: setTokens }}>
      
    </AuthContext.Provider>
  );
};
export default Navbar;