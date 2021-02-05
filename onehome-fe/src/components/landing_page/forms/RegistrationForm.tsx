import { StyledButton } from 'components/styled/StyledButton';
import React from 'react';
import { register } from 'services/AuthenticationService';
import { User } from 'types/User';
import FormInput from '../../form_components/FormInput';
import RegistrationRequest from '../types/requests/RegistrationRequest';
import useFormValidation from '../validation/UseFormValidation';
import validateRegistration from '../validation/ValidateRegistration';

const RegistrationForm = (): JSX.Element => {
  // const history = useHistory();

  const request: RegistrationRequest = {
    firstName: '',
    lastName: '',
    username: '',
    email: '',
    matchingPassword: '',
    password: '',
    role: '',
    gender: 'MALE',
    age: 0,
  };

  const sendRegistrationRequest = async (
    request: RegistrationRequest
  ): Promise<User> => {
    return await register(request);
    // history.push('/login');
  };

  const {
    handleSubmit,
    handleChange,
    handleBlur,
    values,
    errors,
    isSubmitting,
  } = useFormValidation(request, validateRegistration, sendRegistrationRequest);

  return (
    <form
      onSubmit={handleSubmit}
      className="container productwrap shadow-lg rounded mb-0"
      style={{ padding: '20px', marginTop: '50px', width: '30%' }}
    >
      {errors.username && (
        <p className="error-text alert alert-danger">{errors.username}</p>
      )}

      <FormInput
        name="email"
        type="text"
        className={`${errors.email}  ${'error-input'}  ${'form-control'}`}
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
        className={`${errors.password}  ${'error-input'} ${'form-control'}`}
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
        } ${'error-input'} ${'form-control'}`}
        value={values.matchingPassword}
        placeholder="Matching password"
      />

      <br />

      <FormInput
        label="Username"
        name="username"
        type="text"
        className={`${errors.username}  ${'error-input'} ${'form-control'}`}
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
        className={`${errors.firstName} ${'error-input'} ${'form-control'}`}
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
        className={`${errors.lastName} ${'error-input'} ${'form-control'}`}
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
      <br />

      <StyledButton
        type="submit"
        label="Submit"
        className="button"
        onSubmit={isSubmitting}
      />
    </form>
  );
};

export default RegistrationForm;
