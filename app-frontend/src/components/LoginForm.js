import React, { Fragment } from "react";
import FormInput from "./FormInput.js";
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
        <Image src='logo-A0A9B2.jpg' style={{paddingLeft:'30px', width:'40%', height:'auto'}}>
          </Image>
      </Jumbotron>
        <Navbar collapseOnSelect expand="lg" style={{backgroundColor:'#223042', height:'60px'}} variant="dark">
          <Navbar.Brand href="#home" style={{color:'#B4CBE7'}}> We are here for you!</Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav"/>
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="mr-auto py-3 ">
              <Nav.Link href="#features">Resources</Nav.Link>
              <Nav.Link href="#pricing">Shelters near you</Nav.Link>
              <NavDropdown title="Dropdown" id="collasible-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
              </NavDropdown>
            </Nav>
            <Nav>
              <Nav.Link href="#deets">Who we are</Nav.Link>
              <Nav.Link eventKey={2} href="#mem es">
                Contact Us
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      <div  class="container productwrap shadow-lg rounded mb-0" style={{padding:'20px', marginTop:'50px'}}>
        <row >Login page</row>
        <form onSubmit={handleSubmit}>
          {errors.username && (<p className="error-text alert alert-danger">{errors.username}</p>)}
          <FormInput
            label="Username"
            name="username"
            type="text"
            className={`${errors.username} ${"error-input"} ${"form-control"}`}
            value={values.username}
            onChange={handleChange}
            placeholder="Username"
          />
          <br />
          {errors.password && (<p className="error-text alert alert-danger">{errors.password}</p>)}
          <FormInput
            type="password"
            onChange={handleChange}
            onBlur={handleBlur}
            name="password"
            className={`${errors.password}  ${"error-input"} ${"form-control"}`}
            value={values.password}
            placeholder="Password"
          />
          <br/>
          <Button type="submit" label="Login" disabled={isSubmitting}>Submit</Button>
          <Button type="submit" label="Register"  disabled={isSubmitting}>TEST</Button>
          <Button type="submit" label="Forgot password"  disabled={isSubmitting}>TEST</Button>
        </form>
      </div>

    </Fragment>

  );
};
export default LoginForm;
