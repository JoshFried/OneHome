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
import {Button} from "./Button.js";
import {Example }from "./Example";
import {Navbar, Image, NavbarBrandProps, Jumbotron ,NavbarProps, NavLink, Nav, NavDropdown, Form, FormControl, Container, Row, Col} from "react-bootstrap"
import 'react-bootstrap/Navbar';

const INITIAL_STATE = {
    username: "",
    password: "",
};
const LoginForm = () => {
    /*const { setAuthTokens } = useAuth();
    const { setUser } = useUser();*/
    const history = useHistory();
    const loginUser = async (fields) => {
        const result = await authenticate(fields);
        console.log(result);
        /*setUser(await result.user);
        setAuthTokens(await result.token); */
        history.push("/");
    };

    const {
        handleSubmit,
        handleChange,
        handleBlur,
        values,
        errors,
        isSubmitting,
    } = useFormValidation(INITIAL_STATE, ValidateAuthentication, loginUser);

    return (

        <Fragment >
            <Jumbotron fluid  style={{paddingBottom:'15px', paddingTop:'20px',backgroundColor: '#A0A9B2', marginBottom:'0px'}}>
                <Image src='/pictures/logo-A0A9B2.jpg' style={{paddingLeft:'30px', width:'40%', height:'auto'}}>
                </Image>
            </Jumbotron>
            <Navbar collapseOnSelect expand="lg" style={{backgroundImage: 'linear-gradient(15deg, #223042 0%, #5E7898 90%)', height:'60px'   }} variant="dark">
                <Navbar.Brand href="#home" style={{ color:'#B4CBE7'}}> We are here for you!</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto py-3 ">
                        <NavDropdown title="Ressources" id="collasible-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link href="#pricing">Shelters near you</Nav.Link>
                        <Nav.Link href="#features">How to help</Nav.Link>

                    </Nav>
                    <Nav >
                        <Nav.Link href="#deets" style={{color:'#26282B'}}>Who we are</Nav.Link>
                        <Nav.Link eventKey={2} href="#mem es"  style={{color:'#26282B'}}>
                            Contact Us
                        </Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
            {/*
            <div  className="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3" style={{padding:'20px', marginTop:'50px'}}>
                test
            </div>
            <div className="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3" style={{padding: '20px', marginTop: '50px'}}>
            test
            </div>  */}
            <Container>
                <div className='linebox flex' style={{marginTop:'20px'}}>
                    <Row >
                        <Col className='box1 d-md-flex'>
                            <p>
                                <h3>Canada is a reality</h3>
                                <div>
                                Twenty per cent of Canada’s1 homeless population consists of young people between the ages of 13 to 24,2
                                and at least 6,000 young people experience homelessness every night.
                                </div>Most of Canada's young homeless population gravitate to big cities, but homelessness also occurs in
                                other communities—it's just less visible. And the problem starts early. Forty per cent of homeless youth first experience
                                homelessness before the age of 16
                            </p>
                        </Col>
                        <Col className='box1'><Image src='/pictures/homelessgirl.jpg' style={{width:'90%', height:'auto'}}></Image></Col>
                    </Row>
                    <Row className='box ' style={{borderTop:'solid', borderBottom:'solid', fontSize:'20px', padding:'10px'}}>
                        <p> The reality of our cities inspired the creation of One Home</p>
                        <p> We wanted to help every person in need around the world to find the nearest shelter to them and access as quickly as possible the closest local ressources</p>
                        <p> Beyond finding four walls for shelter, we facilitate for organization to signal the space and ressources they still have available</p>
                    </Row>
                </div>
                <footer className="container py-5" style={{borderTop:"solid", position:'fixed'}}>
                    <Row>
                        <Col className=''>
                            <p>The Problem</p>
                            <p>Our Solution</p>
                            <p>Our Impact</p>
                        </Col>
                        <Col className=''>
                            <p>Careers</p>
                            <p>About Us</p>
                        </Col>
                        <Col className=''>
                            <p>Contact Us</p>
                            <p>Policy</p>
                        </Col>
                    </Row>
                </footer>

            </Container>
        </Fragment>

    );
};
export default LoginForm;
