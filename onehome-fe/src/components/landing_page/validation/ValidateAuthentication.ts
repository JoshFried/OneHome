import AuthRequest from "../types/requests/AuthRequest";
import { fieldValidator } from "./FieldValidator";

const validateAuthentication = (request: AuthRequest): string[] => {
  return fieldValidator(request, ["username", "password"]);
};

export default validateAuthentication;
