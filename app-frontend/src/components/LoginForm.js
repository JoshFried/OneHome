import React, { Fragment } from "react";
import FormInput from "./FormInput.js";
import useFormValidation from "./landing_page/validation/UseFormValidation.js";
import ValidateAuthentication from "./landing_page/validation/ValidateAuthentication.js";
import { authenticate } from "../services/AuthenticationService.js";
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

    <Fragment>
      <div  class="container productwrap shadow-lg rounded mb-0" style={{padding:'20px', marginTop:'50px'}}>
        <Row >Login page</Row>
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
          <StyledButton type="submit" label="Login" onSubmit={isSubmitting}>Submit</StyledButton>
          <StyledButton type="submit" label="Forgot password"  onSubmit={isSubmitting}>Create an account!</StyledButton>
          <StyledButton type="submit" label="Register"  onSubmit={isSubmitting}>Forgot your password?</StyledButton>
        </form>
      </div>

    </Fragment>

  );
};
export default LoginForm;
