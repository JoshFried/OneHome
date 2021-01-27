import { Location } from "./Location";
import { Rules } from "./Rules";

export interface Shelter {
  id: number;
  name: string;
  website?: string;
  location: Location;
  rules?: Rules;
}
