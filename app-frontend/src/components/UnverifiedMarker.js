import React, { Component } from "react";
import { connect } from "react-redux";
import { Marker, InfoWindow } from "google-maps-react";
class UnverifiedMarker extends Component {
  render() {
    const google = this.props.google;
    console.log(this.props.data)
    return this.props.data.map((shelter) => {
        return(
        <div>
            <Marker
               name={shelter.name}
               position={{ lat: shelter.geometry.location.lat, lng: shelter.geometry.location.long }}
               onClick={this.props.onClick}
            />
            <InfoWindow onClose={this.props.onClose}>
                <div>
                  <h1>{shelter.name}</h1>
                </div>
            </InfoWindow>
        </div>
        );
    });
  }
}

export default UnverifiedMarker