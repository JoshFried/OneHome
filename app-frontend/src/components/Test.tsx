import React, { useEffect, useState } from 'react';
import { Marker } from './Marker';
import { fetchDataToLoadMap } from 'services/MapsService';
import googleMapReact, { InfoWindow } from 'google-maps-react';
import { MAPS_API_KEY } from 'Utils/config';
export const Map = (): JSX.Element => {
  const [center, setCenter] = useState({
    lat: 45.48051069999999,
    lng: 73.6589462,
  });
  const [zoom, setZoom] = useState(12);

  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position: Position) => {
        const pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
        setCenter(pos);
        (async () => {
          await fetchDataToLoadMap([String(pos.lat), String(pos.lng)]);
        })();
      });
      setZoom(12);
    }
  }, []);

  return (
    <div style={{ height: '100vh', width: '100%' }}>
      <googleMapReact
        bootstrapURLKeys={{ key: MAPS_API_KEY }}
        defaultCenter={center}
        defaultZoom={zoom}
      >
        <Marker
          lat={center.lat}
          lng={center.lng}
          name="My Marker"
          color="red"
        />
      </googleMapReact>
    </div>
  );
};
