import React, {useEffect, useState, setState} from "react";
import TestMap from "./TestMap.js"
import config from'../Utils/config'
import axios from 'axios'
function Search() {
    const [latitude,setLatitude] = useState(0)
    const [longitude,setLongitude] = useState(0)
    const [data,setData] = useState([])
   
    
    return(
        <div>
            <div>hey</div>
            <TestMap/>
        </div>
    )
};
export default Search