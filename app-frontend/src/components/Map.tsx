export const s = '';

// import React, { Fragment, useEffect } from 'react';
// import { handleLocationChange, initMap } from './LoadMap';
// import { StyledButton } from './styled/StyledButton';
// import { GoogleMap } from '@react-google-maps/api';

// export const Map = (): JSX.Element => {
//   const mapContainerStyle = {
//     height: '70vh',
//     width: '100vw',
//   };

//   const center = {
//     lat: 0,
//     lng: 0,
//   };

//   const options = {
//     disabledDefaultUI: true,
//     zoomControl: true,
//   };

//   const mapRef = React.useRef();

//   const onMapLoad = React.useCallback((map) => {
//     mapRef.current = map;
//   }, []);

//   useEffect(() => {
//     initMap();
//   }, []);

//   return (
//     <Fragment>
//       <GoogleMap
//         id="map"
//         mapContainerStyle={mapContainerStyle}
//         center={center}
//         options={options}
//         onLoad={onMapLoad}
//       ></GoogleMap>

//       <StyledButton
//         name="location button"
//         value="Pan to Current Location"
//         className="custom-map-control-button"
//         onClick={handleLocationChange}
//       />
//     </Fragment>
//   );
// };
