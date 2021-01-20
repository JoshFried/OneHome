import React, { Fragment } from 'react';
import { authenticate } from '../../../services/AuthenticationService';
import useFormValidation from '../validation/UseFormValidation';
import validateAuthentication from '../validation/ValidateAuthentication';
import { StyledButton } from '../../styled/StyledButton';
import { FormInput } from '../../form_components/FormInput';
import { Row } from 'reactstrap';
import AuthRequest from '../types/requests/AuthRequest';
import { LoginResponse } from '../types/login/response/LoginResponse';

export const LoginForm = (): JSX.Element => {
  const request: AuthRequest = { username: '', password: '' };

  const loginUser = async (
    request: AuthRequest
  ): Promise<boolean | LoginResponse> => {
    return await authenticate(request);
  };

  const {
    handleSubmit,
    handleChange,
    handleBlur,
    values,
    errors,
    isSubmitting,
  } = useFormValidation(request, validateAuthentication, loginUser);

  return (
    <Fragment>
      <div
        className="container productwrap shadow-lg rounded mb-0"
        style={{ padding: '20px', marginTop: '50px' }}
      >
        <Row>Login page</Row>
        <form onSubmit={handleSubmit}>
          {errors.username && (
            <p className="error-text alert alert-danger">{errors.username}</p>
          )}
          <FormInput
            label="Username"
            name="username"
            type="text"
            className={`${errors.username} ${'error-input'} ${'form-control'}`}
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
            className={`${errors.password}  ${'error-input'} ${'form-control'}`}
            value={values.password}
            placeholder="Password"
          />
          <br />
          <StyledButton type="submit" label="Login" onSubmit={isSubmitting}>
            Submit
          </StyledButton>
          <StyledButton
            type="submit"
            label="Forgot password"
            onSubmit={isSubmitting}
          >
            Create an account!
          </StyledButton>
          <StyledButton type="submit" label="Register" onSubmit={isSubmitting}>
            Forgot your password?
          </StyledButton>
        </form>
      </div>
    </Fragment>
  );
};
