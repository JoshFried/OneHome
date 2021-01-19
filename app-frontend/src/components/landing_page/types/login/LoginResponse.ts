import { User } from '../../../../types/User.js';

export interface LoginResponse {
  token: string;
  user: User;
}
