import { useEffect, useState } from "react";
import { useReducer } from "react";
import { login } from "../../helpers/UserAxios";
import { TYPES } from "../types";
import { UserContext } from "./UserContext";
import { userReducer } from "./userReducer"

export const UserState = ({children}) => {

  const [inSession, setInSession] = useState(false)

    const initialState = {
        username: undefined,
        token: undefined,
        name: undefined,
        
    }

    const [state, dispatch] = useReducer(userReducer, initialState);
    
    useEffect(() => {
      const userToken = JSON.parse(window.localStorage.getItem('user'));
      if(userToken !== null){
        dispatch({
          type: TYPES.SAVE_TOKEN,
          payload: userToken,
        })
      }
    }, [state.token])
    

    
   const userLogin = async(user)=> {
    const token = await login(user);
    setInSession(true);
    dispatch({
        type: TYPES.SAVE_TOKEN,
        payload: token
    })
   }

   const logout = () => {
    setInSession(false);
   }



  return (
  <UserContext.Provider value={{
    token: state.token,
    username: state.username,
    name: state.name,
    userLogin,
    inSession,
    logout
  }}>
    {children}
  </UserContext.Provider>)
}
