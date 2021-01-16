import "../Utils/config";
import React from "react";
import { Redirect } from "react-router-dom";

const URL = global.config.BACKEND_URL;

export const register = async (values) => {
  try {
      await fetch(`${URL}/register`, {
      headers: {
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify(values),
    });

    return <Redirect to="/login" />;
  } catch (error) {
    console.log(error);
  }
};

export const authenticate = async (values) => {
  try {
    const apiRes = await fetch(`${URL}/login`, {
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      method: "POST",
      body: JSON.stringify(values),
    });
    return await apiRes.json();
  } catch (error) {
    return false;
  }
};