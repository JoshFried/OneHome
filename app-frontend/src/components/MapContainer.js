import React, { Component } from 'react';
import { Map, GoogleApiWrapper, InfoWindow, Marker } from 'google-maps-react';
import MAPS_API_KEY from'../Utils/config'

    const mapStyles = {
     width: '100%',
     height: '70%'
     };

export class MapContainer extends Component {
    constructor(props)
    {
        super(props);
        this.state = {
        showingInfoWindow: false,  
        activeMarker: {},         
        selectedPlace: {}          
        };

    }
   
  onMarkerClick = (props, marker, e) =>
    this.setState({
      selectedPlace: props,
      activeMarker: marker,
      showingInfoWindow: true
    });

  onClose = props => {
    if (this.state.showingInfoWindow) {
      this.setState({
        showingInfoWindow: false,
        activeMarker: null
      });
    }
  };
  render() {
    return (
      <Map
        google={this.props.google}
        zoom={14}
        style={mapStyles}
        initialCenter={
          {
            lat: -1.2884,
            lng: 36.8233
          }
        }
      >
        <Marker
          onClick={this.onMarkerClick}
          name={'You are here!'}
        />
        <InfoWindow
          marker={this.state.activeMarker}
          visible={this.state.showingInfoWindow}
          onClose={this.onClose}
        >
          <div>
            <h4>{this.state.selectedPlace.name}</h4>
          </div>
        </InfoWindow>
      </Map>
    );
  }
}

export default GoogleApiWrapper({
  apiKey: MAPS_API_KEY
})(MapContainer);