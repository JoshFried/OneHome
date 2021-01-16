import { useContext } from "react";
import { createContext } from "react";

export const useUserContext = createContext(null);

export const useUser = () => {
  return useContext(useUserContext);
};