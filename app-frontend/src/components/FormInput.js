import React, { Fragment } from "react";

const FormInput = ({
  name,
  type,
  placeholder,
  onChange,
  className,
  value,
  error,
  onBlur,
}) => {
  return (
    <Fragment>
      <input
        id={name}
        name={name}
        placeholder={placeholder}
        value={value}
        className={className}
        type={type}
        onBlur={onBlur}
        onChange={onChange}
      />
      {error && <p>{error}</p>}
    </Fragment>
  );
};

export default FormInput;
