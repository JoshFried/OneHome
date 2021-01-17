import React from "react";
import {Button} from "reactstrap"
function RedirectButton(props){
  return (
    <a href={props.link} className="btn btn-info" role="button">{props.name}</a>
  );
};
export default RedirectButton
