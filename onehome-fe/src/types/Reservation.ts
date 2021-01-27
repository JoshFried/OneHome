import { Shelter } from "./Shelter";
import { User } from "./User";

export interface Reservation {
  id: number;
  shelter: Shelter;
  user: User;
  createdAt: Date;
  expiresAt: Date;
}
