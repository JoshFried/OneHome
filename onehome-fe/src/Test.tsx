import React, { useEffect, useState } from "react";
import { Marker } from "./Marker";
import { fetchDataToLoadMap } from "services/MapsService";
import GoogleMapReact from "google-map-react";
import { THE_API_KEY } from "Utils/config";
export const Map = (): JSX.Element => {
  const [center, setCenter] = useState({
    lat: 45.48051069999999,
    lng: 73.6589462,
  });
  const [zoom, setZoom] = useState(12);

  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position: GeolocationPosition) => {
          const pos = {
            lat: position.coords.latitude,
            lng: position.coords.longitude,
          };
          setCenter(pos);
          (async () => {
            console.log(
              await fetchDataToLoadMap([String(pos.lat), String(pos.lng)])
            );
          })();
        }
      );
      setZoom(12);
    }
  }, []);

  const mapContainerStyle = {
    height: "70vh",
    width: "100vw",
  };

  return (
    <div style={{ height: "100vh", width: "100%" }}>
      <GoogleMapReact
        bootstrapURLKeys={{ key: THE_API_KEY }}
        defaultCenter={center}
        defaultZoom={zoom}
        yesIWantToUseGoogleMapApiInternals={true}
        style={mapContainerStyle}
      >
        <Marker
          lat={center.lat}
          lng={center.lng}
          name="My Marker"
          color="red"
        />
      </GoogleMapReact>
    </div>
  );
};
