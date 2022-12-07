import { useEffect, useState } from "react";
import { useReducer } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../../helpers/UserAxios";
import { TYPES } from "../types";
import { UserContext } from "./UserContext";
import { userReducer } from "./userReducer"


export const UserState = ({children}) => {

  const navigate = useNavigate();

    const initialState = {
        username: undefined,
        token: undefined,
        name: undefined,
        inSession: false,    
    }

    const [state, dispatch] = useReducer(userReducer, initialState);

    useEffect(() => {
      const userToken = JSON.parse(window.localStorage.getItem('user'));
      if(userToken !== null){
        dispatch({
          type: TYPES.SAVE_TOKEN,
          payload: userToken,
        });
      }
    }, [state.token])
    
    
    
   const userLogin = async(user)=> {
    const token = await login(user);
    dispatch({
        type: TYPES.SAVE_TOKEN,
        payload: token
    })
   }


   const logout = () => {
    window.localStorage.removeItem('user');
    dispatch({ 
      type: TYPES.LOGOUT,
    })
    navigate('/login');
   }

   const loginNavigate = () => {
    navigate('/login');
   }

  return (
  <UserContext.Provider value={{
    token: state.token,
    username: state.username,
    name: state.name,
    userLogin,
    inSession: state.inSession,
    logout,
    login: loginNavigate
  }}>
    {children}
  </UserContext.Provider>)
}
