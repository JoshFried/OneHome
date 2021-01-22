import { fieldValidator } from 'components/landing_page/validation/FieldValidator';
import RegistrationRequest from '../types/requests/RegistrationRequest';

const validateRegistration = (values: RegistrationRequest): string[] => {
  return [
    ...fieldValidator(values, [
      'username',
      'password',
      'firstName',
      'lastName',
      'email',
    ]),
    checkEmail(values.email),
    checkPassword(values.password),
    checkPasswordMatches(values.password, values.matchingPassword),
  ].filter((value) => value !== '');
};

const checkPassword = (password: string): string => {
  if (password.length < 6) return 'Password must be at least 6 characters';
  return '';
};

const checkEmail = (email: string): string => {
  if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email))
    return 'Invalid email address';
  return '';
};

const checkPasswordMatches = (password: string, matchingPassword: string) => {
  if (password !== matchingPassword) return 'Passwords dont match!';
  return '';
};

export default validateRegistration;
