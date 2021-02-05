import React from 'react';
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import { Button, ButtonProps } from 'react-bootstrap';

interface ButtonPropsType extends ButtonProps {
  label: string;
}

export const StyledButton = (props: ButtonPropsType): JSX.Element => {
  return (
    <Button
      type={props.type}
      className={props.className}
      disabled={props.disabled}
      onClick={props.onClick}
      style={{
        backgroundColor: 'white',
        borderRadius: '10px',
        padding: '5px',
        margin: '5px',
        border: '1px solid #C8D8EA',
        color: 'black',
      }}
    >
      {props.label}
    </Button>
  );
};
