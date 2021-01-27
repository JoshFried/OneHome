import { createContext, useContext } from "react";

type AuthContextType = {
  token: string;
  setTokens: (token: string) => void;
};

export const AuthContext = createContext<AuthContextType>({
  token: "",
  setTokens: (data) => {
    token: data;
  },
});

export const useAuth = (): AuthContextType => {
  return useContext(AuthContext);
};
