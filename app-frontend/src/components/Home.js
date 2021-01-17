import React, { Fragment } from "react";
import FormInput from "./FormInput.js";
import '../CSS/homepage.css';
import useFormValidation from "./UseFormValidation.js";
import ValidateAuthentication from "./ValidateAuthentication.js";
import { authenticate } from "./AuthenticationService.js";
import { useAuth } from "./Auth.js";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useUser } from "./UserContext.js";
import {StyledButton} from "./StyledButton.js";
import {Example }from "./Example";
import {Navbar, Image, NavbarBrandProps, Jumbotron ,NavbarProps, NavLink, Nav, NavDropdown, Form, FormControl, Container, Row, Col} from "react-bootstrap"
import 'react-bootstrap/Navbar';

const INITIAL_STATE = {
    username: "",
    password: "",
};
const LoginForm = () => {

    return (

        <Fragment >
            <Container style={{width:'90%', height:'auto'}}>
                <div className='linebox container flex' style={{width:'90%', height:'auto', marginTop:'20px'}}>
                    <div style={{display:'flex'}}>
                        <div className='box1' style={{alignItems:'flex-start', justifyContent:'flex-start'}}>
                            <Image src='/pictures/homelessgirl.jpg' style={{width:'100%', height:'auto'}}></Image>
                        </div>

                        <div className='box1 '  style={{alignItems:'flex-end', justifyContent:'flex-end'}}>
                            <p>
                                <h3>Canada is a reality</h3>
                                <div>
                                Twenty per cent of Canada’s1 homeless population consists of young people between the ages of 13 to 24,2
                                and at least 6,000 young people experience homelessness every night.
                                </div>Most of Canada's young homeless population gravitate to big cities, but homelessness also occurs in
                                other communities—it's just less visible. And the problem starts early. Forty per cent of homeless youth first experience
                                homelessness before the age of 16
                            </p>
                        </div>
                    </div>
                    <Row className='box ' style={{height:'30%', borderTop:'solid', borderBottom:'solid', fontSize:'20px', padding:'10px'}}>
                        <p> The reality of our cities inspired the creation of One Home</p>
                        <p> We wanted to help every person in need around the world to find the nearest shelter to them and access as quickly as possible the closest local resources</p>
                        <p> Beyond finding four walls for shelter, we facilitate for organization to signal the space and resources they still have available</p>
                    </Row>
                </div>


            </Container>
            
        </Fragment>

    );
};
export default LoginForm;
