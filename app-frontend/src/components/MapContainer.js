import React, { Component, useState, setState } from 'react';
import { Map, GoogleApiWrapper, InfoWindow, Marker } from 'google-maps-react';
import config from'../Utils/config'
import axios from 'axios';
import UnverifiedMarker from "./UnverifiedMarker"
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
        selectedPlace: {},
        unverifiedShelters: [],
        verifiedShelters:[],          
        };
    }
    async componentDidMount()
    {
        axios.get(`https://maps.googleapis.com/maps/api/place/nearbysearch/json?input=homeless%20shelter&keyword=homeless%20shelter&inputtype=textquery&fields=photos,geometry,formatted_address,name,opening_hours,rating&radius=100000&location=${this.props.latitude},${this.props.longitude}&key=${config.MAPS_API_KEY}`,{})
        .then((response) => {
            let results = response.data.results
            this.setState({
                unverifiedShelters : response.data.results
            })

        }).catch((err) => {
            console.log(err)           
        })
    }
   displayMarkers = () => {
      return this.state.unverifiedShelters.map((shelter) => {
          console.log(shelter.geometry)
        return 
         <div>
          <Marker class = "unverified" key = {shelter.place_id} position = {{lat: shelter.geometry.location.lat, lng: shelter.geometry.location.long}} onClick={this.onMarkerClick()}
          name={'Shelter is here!'}/>
          <InfoWindow
          marker={this.state.activeMarker}
          visible={this.state.showingInfoWindow}
          onClose={this.onClose}>
            <div>
                <h2>ur here!</h2>
            </div>
        </InfoWindow>
        </div>    
            
      })
  }
  onMarkerClick = (props, marker, e) => {
      console.log("1")
    this.setState({
      selectedPlace: props,
      activeMarker: marker,
      showingInfoWindow: true
    });
  }

  onClose = props => {
    if (this.state.showingInfoWindow) {
      this.setState({
        showingInfoWindow: false,
        activeMarker: null
      });
    }
  };
  render() {
    console.log(this.state.unverifiedShelters, "mapcontainer")
    return (
      <Map
        google={this.props.google}
        zoom={14}
        style={mapStyles}
        initialCenter={
          {
            lat: this.props.latitude,
            lng: this.props.longitude
          }
        }
        >
        <UnverifiedMarker google = {this.props.google} data = {this.state.unverifiedShelters} onClick={this.onMarkerClick} onClose={this.onClose}/>
        <Marker
          onClick={this.onMarkerClick}
          name={'You are here!'}
        />
        <InfoWindow
          marker={this.state.activeMarker}
          visible={this.state.showingInfoWindow}
          onClose={this.onClose}>
            <div>
                <h2>ur here!</h2>
            </div>
        </InfoWindow>
      </Map>
    );
  }
}

export default GoogleApiWrapper({
  apiKey: config.MAPS_API_KEY
})(MapContainer);