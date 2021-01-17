import React, {useEffect, useState, setState} from "react";
import TestMap from "./TestMap.js"
import config from'../Utils/config'
import axios from 'axios'
function Search() {
    const [latitude,setLatitude] = useState(0)
    const [longitude,setLongitude] = useState(0)
    const [data,setData] = useState([])
    return(
        <div className="container productwrap  rounded" >
                <p> Please enter your current location here:</p>
            <div style={{height:'30%', width:'50%'}}>
                <TestMap/>
            </div>
        </div>
    )
}
export default Search