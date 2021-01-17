import React, { Fragment } from "react";
import FormInput from "./FormInput.js";
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

  const history = useHistory();
  const loginUser = async (fields) => {
    const result = await authenticate(fields);
    console.log(result);
    if(result === false)
    {
        alert("Invalid credentials");
    }
    else
    {
        history.push("/");
    }
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

    <Fragment>
      <div  class="container productwrap shadow-lg rounded mb-0" style={{padding:'20px', width:'40%', marginTop:'50px'}}>
        <form onSubmit={handleSubmit} style={{marginTop:'1%'}}>
          {errors.username && (<p className="error-text alert alert-danger">{errors.username}</p>)}
          <Row style={{alignText:'center', paddingLeft:'45%', paddingBottom:'2%'}}>Login</Row >

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
          <div>
            <StyledButton
                type="submit"
                label="Login"
                onSubmit={isSubmitting}
                className="button btn-block"
                style={{width:'100px' }}
                block="true"
            />
          </div>
          <Row>
              <Col>
                  <StyledButton
                      type="submit"
                      label="Forgot password"
                      onSubmit={isSubmitting}
                      className="button btn-block"
                      style={{width:'100px' }}
                      block="true"
                  >
                    Create an account!\
                  </StyledButton>
              </Col>
              <Col>
                  <Link to="/register">
                       <StyledButton
                           type="submit"
                           label="Register"
                           onSubmit={isSubmitting}
                           className="button btn-block"
                           style={{width:'100px' }}
                           block="true"
                       >Forgot your password?</StyledButton>
                  </Link>
              </Col>
          </Row>
          </form>
      </div>


    </Fragment>

  );
};
export default LoginForm;
