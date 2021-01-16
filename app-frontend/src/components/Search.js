import React, {useEffect, useState, setState} from "react";
import MapContainer from "./MapContainer.js"
import config from'../Utils/config'
function Search() {
    const [latitude,setLatitude] = useState(0)
    const [longitude,setLongitude] = useState(0)
    useEffect(() => {
        navigator.geolocation.getCurrentPosition((position) => {
        console.log(position)
        setLatitude(position.coords.latitude)
        setLongitude(position.coords.longitude)
    })
    },[])
    
    return(
        <div>
            <div>hey</div>
            <MapContainer latitude = {latitude} longitude = {longitude}/>
        </div>
    )
};
export default Search