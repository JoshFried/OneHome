import React, {useEffect, useState, useCallback} from "react";
import {
  GoogleMap,
  useLoadScript,
  Marker,
  InfoWindow,
} from "@react-google-maps/api";
function UnverifiedShelters(props){
    <Marker
               className = "verifiedMarker"
               key={props.place_id}
               position={props.geometry.location}
               onClick={event => markerClickHandler(event, shelter)}
              />
            ))}
            {infoOpen && selectedPlace && 
            (
                <InfoWindow
                className = "verifiedWindow"
                    position = {selectedPlace.geometry.location}
                    onCloseClick={() => setInfoOpen(false)}
                >
                <div>
                    <h1>{selectedPlace.name}</h1>
                    <h3>{selectedPlace.business_status}</h3>
                    <div>been tryna meet ya</div>
                    <RedirectButton name = "Google Maps Link" link = {`https://www.google.com/maps/search/?api=1&query=Google&query_place_id=${selectedPlace.place_id}`}/>
                    <div>{selectedPlace.vicinity}</div>
                    {selectedPlace.opening_hours && 
                    <div>Open: {selectedPlace.open_now ? "Yes" : "No"}</div>
                    }
                  </div>
                </InfoWindow>
            )}

}
export default UnverifiedShelters