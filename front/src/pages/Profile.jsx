import React, {useContext} from 'react'
import '../styles/profile.css'
import {UserContext} from '../context/user/UserContext';
import Perfil from '../images/perfil.png'
import { Link } from 'react-router-dom';


export const Profile = () => {
  
  const {username, logout} = useContext(UserContext);

  return (
    <>
    <div className="d-flex">
      <nav className="navbar d-flex flex-column shadow sidebar rounded-top w-25 align-items-center justify-content-between">
      <div>
        <img src={Perfil} className="img-fluid rounded-circle  img-perfil" />
        <p className='text-center'>{username}</p>
      </div>
        <div className="d-flex flex-column lista h-75 justify-content-around align-items-center">
          <Link to='/' className="links text-center text-decoration-none text-secondary">Ir al inicio</Link>
          <Link to='/completar' className=" links text-center text-decoration-none text-secondary">Completar datos</Link>
          <Link to='/propiedades/administrar' className=" links text-center text-decoration-none text-secondary">Administrar propiedades</Link>
          <Link to='/turnos' className=" links text-center text-decoration-none text-secondary">Administrar turnos</Link>
          <button onClick={logout} className=" btn cerrar-sesion links text-center">Cerrar Sesión</button>
        </div>
      </nav>
      <div className="w-75 contenido-sidebar">
        <h2 className="text-center">Seccion del sidebar</h2>
      </div>
    </div>
    </>
  );
}
