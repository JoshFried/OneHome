import React, {useEffect, useState, setState} from "react";
import MapContainer from "./MapContainer.js"
function Search()
{
    const [latitude,setLatitude] = setState(0)
    const [longitude,setLongitude] = setState(0)
    useEffect(() => {
        navigator.geolocation.getCurrentPosition((position) => {
        setLatitude(position.coords.latitude)
        setLongitude(position.coords.longitude)
    });
    },[])
    
    return(
    <div>
        <div>hey</div>
        <MapContainer latitude = {latitude} longitude = {longitude}/>
    </div>
    )
}
export default Search