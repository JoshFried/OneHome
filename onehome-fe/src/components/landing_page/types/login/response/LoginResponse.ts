import { User } from "types/User";

export interface LoginResponse extends User {
  token: string;
}
