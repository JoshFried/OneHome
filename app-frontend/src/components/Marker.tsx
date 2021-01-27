import React from 'react';
// import './Marker.css';

export const Marker = (props: any): JSX.Element => {
  return (
    <div
      className="marker"
      style={{ backgroundColor: props.color, cursor: 'pointer' }}
      title={props.name}
    />
  );
};
