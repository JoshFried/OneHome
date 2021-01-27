import React, { Fragment } from "react";
// import './Marker.css';

export const Marker = (props: any): JSX.Element => {
  const { color, name } = props;
  return (
    <Fragment>
      <div
        className="marker"
        style={{ backgroundColor: color, cursor: "pointer" }}
        title={name}
      />
    </Fragment>
  );
};
