import { BACKEND_URL } from '../Utils/config';
import RegistrationRequest from '../components/landing_page/types/requests/RegistrationRequest';
import { User } from 'types/User';
import { LoginResponse } from 'components/landing_page/types/login/response/LoginResponse';
import AuthRequest from 'components/landing_page/types/requests/AuthRequest';

export const register = async (request: RegistrationRequest): Promise<User> => {
  try {
    const apiRes = await fetch(`${BACKEND_URL}/register`, {
      headers: {
        'Content-Type': 'application/json',
      },
      method: 'POST',
      body: JSON.stringify(request),
    });
    return await apiRes.json();
  } catch (error) {
    throw error;
  }
};

export const authenticate = async (
  values: AuthRequest
): Promise<LoginResponse> => {
  try {
    const apiRes = await fetch(`${BACKEND_URL}/login`, {
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
      method: 'POST',
      body: JSON.stringify(values),
    });
    return await apiRes.json();
  } catch (error) {
    throw error;
  }
};

export const getUserInfo = async (): Promise<User> => {
  try {
    const apiRes = await fetch(`${BACKEND_URL}/user`, {
      headers: {
        'Content-Type': 'application/json',
      },
      credentials: 'include',
    });
    return await apiRes.json();
  } catch (error) {
    throw error;
  }
};
