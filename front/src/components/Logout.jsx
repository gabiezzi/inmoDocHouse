import React, { useContext } from 'react'
import { useNavigate } from 'react-router-dom';
import { UserContext } from '../context/user/UserContext';

export const Logout = () => {
    const { logout } = useContext(UserContext);
    const navigate = useNavigate();

    const userLogout = () => {
        logout();
        window.localStorage.removeItem('user');
        setTimeout(() => {
            navigate("/");
        }, 1500);
    }

    userLogout();

  return (
    <>
        <div className='col-12 d-flex justify-content-center align-items-center'>
            <span className='alert alert-success w-50 text-center'>
                Gracias por usar nuestros servicios
            </span>
        </div>
    </>
  )
}
