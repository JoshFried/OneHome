import { defaultUser } from 'DefaultUser';
import { useContext } from 'react';
import { createContext } from 'react';
import { User } from 'types/User';

type UserContextType = {
  user: User;
  setUser: (user: User) => void;
};

export const UserContext = createContext<UserContextType>({
  user: defaultUser,
  setUser: (user) => {
    user: user;
  },
});

export const useUser = (): UserContextType => {
  return useContext(UserContext);
};
