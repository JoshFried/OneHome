import React from "react";
import FormInput from "./FormInput.js";
import { StyledButton } from "./StyledButton.js";
import { register } from "./AuthenticationService.js";
import ValidateRegistration from "./ValidateRegistration.js";
import useFormValidation from "./UseFormValidation.js";
import { useHistory } from "react-router-dom";

const INITIAL_STATE = {
  email: "",
  password: "",
  matchingPassword: "",
  username: "",
  firstName: "",
  lastName: "",
  role: "OCCUPANT",
};

const RegistrationForm = () => {
  const history = useHistory();

  const sendRegistrationRequest = async (fields) => {
    await register(fields);
    history.push("/login");
  };

  const {
    handleSubmit,
    handleChange,
    handleBlur,
    values,
    errors,
    isSubmitting,
  } = useFormValidation(
    INITIAL_STATE,
    ValidateRegistration,
    sendRegistrationRequest
  );

  return (
    <form onSubmit={handleSubmit} className="form-signin">
      {errors.username && (
        <p className="error-text alert alert-danger">{errors.username}</p>
      )}

      <FormInput
        name="email"
        type="text"
        className={`${errors.email}  ${"error-input"}  ${"form-control"}`}
        onBlur={handleBlur}
        value={values.email}
        onChange={handleChange}
        placeholder="Email address"
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

      <FormInput
        type="password"
        onChange={handleChange}
        onBlur={handleBlur}
        name="matchingPassword"
        className={`${
          errors.matchingPassword
        } ${"error-input"} ${"form-control"}`}
        value={values.matchingPassword}
        placeholder="Matching password"
      />

      <br />

      <FormInput
        label="Username"
        name="username"
        type="text"
        className={`${errors.username}  ${"error-input"} ${"form-control"}`}
        value={values.username}
        onBlur={handleBlur}
        onChange={handleChange}
        placeholder="Username"
      />

      <br />

      <FormInput
        label="FirstName"
        name="firstName"
        type="text"
        className={`${errors.firstName} ${"error-input"} ${"form-control"}`}
        value={values.firstName}
        onBlur={handleBlur}
        onChange={handleChange}
        placeholder="First Name"
      />

      <br />

      <FormInput
        label="LastName"
        name="lastName"
        type="text"
        className={`${errors.lastName} ${"error-input"} ${"form-control"}`}
        value={values.lastName}
        onChange={handleChange}
        onBlur={handleBlur}
        placeholder="Last Name"
      />

      <br />
      <select
        onChange={handleChange}
        onBlur={handleBlur}
        defaultValue="OCCUPANT"
        name="role"
      >
        <option value="ADMIN">Shelter Owner</option>
        <option value="OCCUPANT">Shelter Seeker</option>
      </select>
      <br/>

      <StyledButton
        type="submit"
        label="Submit"
        className="button"
        disabled={isSubmitting}
      />
    </form>
  );
};

export default RegistrationForm;
