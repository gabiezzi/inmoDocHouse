import { useReducer } from "react";
import { UserContext } from "./UserContext";
import { userReducer } from "./userReducer"

export const UserState = ({children}) => {

    const initialState = {
        username: undefined,
        token: undefined,
        name: undefined,
    }

    const [state, dispatch] = useReducer(userReducer, initialState);


  return (
  <UserContext.Provider value={{
    token: state.token,
    username: state.username,
    name: state.name
  }}>
    {children}
  </UserContext.Provider>)
}
