import { useEffect } from "react";
import { useReducer } from "react";
import { login } from "../../helpers/UserAxios";
import { TYPES } from "../types";
import { UserContext } from "./UserContext";
import { userReducer } from "./userReducer"

export const UserState = ({children}) => {

    const initialState = {
        username: undefined,
        token: undefined,
        name: undefined,
    }

    const [state, dispatch] = useReducer(userReducer, initialState);
    
    useEffect(() => {
      const userToken = JSON.parse(window.localStorage.getItem('user'));
      dispatch({
        type: TYPES.SAVE_TOKEN,
        payload: userToken,
      })
      console.log(state.token);   
    }, [state.token])
    

    
   const userLogin = async(user)=> {
    const token = await login(user);
    dispatch({
        type: TYPES.SAVE_TOKEN,
        payload: token
    })
   }

   


  return (
  <UserContext.Provider value={{
    token: state.token,
    username: state.username,
    name: state.name,
    userLogin,
  }}>
    {children}
  </UserContext.Provider>)
}
