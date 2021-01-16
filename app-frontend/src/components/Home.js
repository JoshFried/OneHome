import React, { useState, useEffect } from "react";
import LoginForm from "./LoginForm.js"
import axios from "axios"
function Home() {
    useEffect(()=>
    {
        axios.get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=homeless%20shelter&inputtype=textquery&fields=photos,formatted_address,name,opening_hours,rating&key=AIzaSyDIpjXbG67pNIXxcrACuw8hmI60qb_CWVs")
        .then(response =>
        {
            console.log(response);
        })
    })
  return(
      <div>
          <div>hey</div>
          <div>been tryna meet ya</div>
      </div>
  )
}
export default Home;