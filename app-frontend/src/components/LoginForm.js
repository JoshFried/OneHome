import React, { Fragment } from "react";
import FormInput from "./FormInput.js";
import useFormValidation from "./UseFormValidation.js";
import ValidateAuthentication from "./ValidateAuthentication.js";
import { authenticate } from "./AuthenticationService.js";
import { useAuth } from "./Auth.js";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useUser } from "./UserContext.js";
import {StyledButton} from "./StyledButton.js"
import {Container, Form} from "react-bootstrap"
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
    <Container>
      <Form onSubmit={handleSubmit}>
        {errors.username && (
          <p className="error-text alert alert-danger">{errors.username}</p>
        )}
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
        {errors.password && (
          <p className="error-text alert alert-danger">{errors.password}</p>
        )}
        <FormInput
          type="password"
          onChange={handleChange}
          onBlur={handleBlur}
          name="password"
          className={`${errors.password}  ${"error-input"} ${"form-control"}`}
          value={values.password}
          placeholder="Password"
        />
        <br />
        <StyledButton type="submit" label="Submit" disabled={isSubmitting}>
          Submit
        </StyledButton>
      </Form>
    </Container>
  );
};
export default LoginForm;
