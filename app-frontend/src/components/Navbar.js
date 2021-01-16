import React, { useState } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "./Auth";
import Axios from "axios";
import "../Utils/config";
import { useUser } from "./UserContext";

const Navbar = (props) => {



  const { user, setUser } = useUser();

  const [authTokens, setAuthTokens] = useState(
    localStorage.getItem("token") || ""
  );

  const setTokens = (data) => {
    localStorage.setItem("token", JSON.stringify(data));
    setAuthTokens(data);
  };

  const handleLogout = () => {
    localStorage.removeItem("token");
    setUser(null);
    Axios.get(global.config.BACKEND_URL + `/logout`);
  }; 

  return (
    <AuthContext.Provider value={{ authTokens, setAuthTokens: setTokens }}>
      
    </AuthContext.Provider>
  );
};
export default Navbar;