import React, { Fragment } from "react";
import { FormInputTypes } from "./FormInputTypes";

export const FormInput = (props: FormInputTypes): JSX.Element => {
  return (
    <Fragment>
      <input
        id={props.name}
        name={props.name}
        placeholder={props.placeholder}
        value={props.value}
        className={props.className}
        type={props.type}
        onBlur={props.onBlur}
        onChange={props.onChange}
      />
      {props.error && <p>{props.error}</p>}
    </Fragment>
  );
};

export default FormInput;
