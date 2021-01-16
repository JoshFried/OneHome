import React from "react";
import {Button} from "reactstrap"
function RedirectButton(props){
  return (
    <a href={props.link} class="btn btn-info" role="button">Link Button</a>
  );
};
export default RedirectButton
