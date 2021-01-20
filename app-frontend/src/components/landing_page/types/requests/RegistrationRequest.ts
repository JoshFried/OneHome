import AuthRequest from './AuthRequest';

export default interface RegistrationRequest extends AuthRequest {
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  matchingPassword: string;
  password: string;
  role: string;
  gender: string;
  age: number;
}
