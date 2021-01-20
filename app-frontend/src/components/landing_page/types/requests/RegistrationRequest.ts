import AuthRequest from './AuthRequest';

export default interface RegistrationRequest extends AuthRequest {
  firstName: string;
  lastName: string;
  email: string;
  matchingPassword: string;
  role: string;
  gender: string;
  age: number;
}
