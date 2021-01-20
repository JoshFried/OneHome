import '../Utils/config';
import React from 'react';
import { Redirect } from 'react-router-dom';
import RegistrationRequest from '../components/landing_page/types/requests/RegistrationRequest';
import { LoginResponse } from '~/components/landing_page/types/login/LoginResponse';
import { LoginRequest } from '~/components/landing_page/types/requests/LoginRequest';

const URL: string = global.config.BACKEND_URL;

export const register = async (request: RegistrationRequest) => {
  console.log('line 8');
  try {
    await fetch(`${URL}/register`, {
      headers: {
        'Content-Type': 'application/json',
      },
      method: 'POST',
      body: JSON.stringify(request),
    });

    return <Redirect to="/login" />;
  } catch (error) {
    console.log(error);
  }
};

export const authenticate = async (
  values: LoginRequest
): Promise<LoginResponse | boolean> => {
  try {
    const apiRes = await fetch(`${URL}/login`, {
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
      method: 'POST',
      body: JSON.stringify(values),
    });
    return await apiRes.json();
  } catch (error) {
    return false;
  }
};
