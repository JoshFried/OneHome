import RegistrationRequest from '../types/requests/RegistrationRequest';

const ValidateRegistration = (
  values: RegistrationRequest
): (string | boolean)[] => {
  const requiredFields = [
    'username',
    'password',
    'firstName',
    'lastName',
    'email',
  ];

  return [
    ...requiredFields.map((field) => checkRequiredField(field)),
    checkEmail(values.email),
    checkPassword(values.password),
    checkPasswordMatches(values.password, values.matchingPassword),
  ].filter((value) => value !== true);
};

const checkRequiredField = (field: string): string | boolean => {
  if (!field) return `${field} is required`;
  return true;
};

const checkPassword = (password: string) => {
  if (password.length < 6) return 'Password must be at least 6 characters';
  return true;
};

const checkEmail = (email: string) => {
  if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email))
    return 'Invalid email address';
  return true;
};

const checkPasswordMatches = (password: string, matchingPassword: string) => {
  return password === matchingPassword;
};

export default ValidateRegistration;
