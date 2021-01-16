import React from "react";
import 'bootstrap/dist/css/bootstrap-grid.min.css'
//import {Button} from 'react-bootstrap';

export const Button = (props) => {
  return (
    <button
      type={props.type}
      className={props.className}
      disabled={props.disabled}
//      color={props.color} doesnt work
     /// variant={props.variant}
        style={{backgroundColor: "white", borderRadius:'10px', padding:'5px', margin:'5px', border:'1px solid #C8D8EA'}}
    >
      {props.label}
    </button>
  );
};
