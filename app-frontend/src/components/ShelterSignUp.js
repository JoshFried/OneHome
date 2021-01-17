import React from "react"
import {StyledButton} from "./StyledButton"
import Rules from "./Rules.js"
import axios from 'axios'
import config from "../Utils/config"
function ShelterSignUp(props){
    const onSignUpClick = (e) =>{
        e.preventDefault();
        axios.post(`${config.BACKEND_URL}/rsvp/1`, {withCredentials:true},
        {        
        }).then(response => {
            console.log(response)
        }).catch(err =>
        {
            console.log(err)
        })
    }
    const onWaitClick = (e) =>{
        e.preventDefault();
        axios.post(`${config.BACKEND_URL}/wait/1`, {withCredentials:true},
        {        
        }).then(response => {
            console.log(response)
        }).catch(err =>
        {
            console.log(err)
        })
    }
    return(
    <div>
        <Rules rules = {props.rules}></Rules>
        {props.rules ? <StyledButton label = "Sign Up!" onClick = {onSignUpClick}></StyledButton> :
                       <StyledButton label = "Get an email reminder when this opens up!" onClick = {onWaitClick}></StyledButton>
        }
    </div>
    )
}
export default ShelterSignUp