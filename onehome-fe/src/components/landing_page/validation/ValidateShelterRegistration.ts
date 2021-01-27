import { ShelterRequest } from "../types/requests/ShelterRequest";
import { fieldValidator } from "./FieldValidator";

export const validateShelter = (values: ShelterRequest): string[] => {
  return fieldValidator(values, [
    "name",
    "placeId",
    "capacity",
    "placeId",
    "longitude",
  ]);
};
