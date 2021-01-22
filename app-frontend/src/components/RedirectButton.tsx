import React from 'react';
import { RedirectButtonProps } from './shelter_registration/RedirectButtonProps';

export const RedirectButton = (props: RedirectButtonProps): JSX.Element => {
  return (
    <a href={props.url} className="btn btn-info" role="button">
      {props.name}
    </a>
  );
};
