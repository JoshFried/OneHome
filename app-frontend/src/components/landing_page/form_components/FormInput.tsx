import React, { Fragment } from 'react';

export const FormInput: React.FunctionComponent = ({
  ...props
}): JSX.Element => {
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
    </Fragment>
  );
};