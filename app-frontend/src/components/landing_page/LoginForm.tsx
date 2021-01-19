import React from 'react';
import { authenticate } from '../../services/AuthenticationService';
import { LoginRequest } from './types/login/LoginRequest';
import useFormValidation from './validation/UseFormValidation';
import ValidateAuthentication from './validation/ValidateAuthentication';

export const LoginForm = () => {
  const request: LoginRequest = { username: '', password: '' };

  const loginUser = async (fields: string) => {
    const result = await authenticate(fields);
  };

  const {
    handleSubmit,
    handleChange,
    handleBlur,
    values,
    errors,
    isSubmitting,
  } = useFormValidation(request, ValidateAuthentication, loginUser);

  return (
    <div>
      <form></form>
    </div>
  );
};


