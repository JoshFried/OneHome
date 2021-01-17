import React from "react";
import {Button} from "reactstrap"
export const StyledButton = (props) => {
  return (
    <button
      type={props.type}
      className={props.className}
      disabled={props.disabled}
    >
      {props.label}
    </button>
  );
};
