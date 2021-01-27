import React, { Fragment } from "react";
import { RedirectButtonProps } from "./components/shelter_registration/RedirectButtonProps";

export const RedirectButton = (props: RedirectButtonProps): JSX.Element => {
  return (
    <Fragment>
      <a href={props.url} className="btn btn-info" role="button">
        {props.name}
      </a>
    </Fragment>
  );
};
