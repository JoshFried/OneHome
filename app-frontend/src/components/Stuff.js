import React from "react";
import axios from "axios";
import config from "../Utils/config";
const Stuff = (props) => {
  axios
    .post(
      `${config.BACKEND_URL}/shelter/admin/create`,
      {
        ShelterDTO: props,
      },
      {
        withCredentials: true,
      },
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    )
    .catch((err) => {
      console.log(props.info);
      console.log(err);
    });
};
export default Stuff;
