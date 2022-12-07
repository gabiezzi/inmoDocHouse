import { useContext, useEffect } from 'react';
import { UserContext } from '../../context/user/UserContext.js';
import { NavButton } from './NavButton.jsx'

export const NavLinks = () => {
  const { inSession, logout } = useContext(UserContext);

  
  return (
    <ul className="NavLinks">
      <NavButton name="Alquila" to="alquila" />
      <NavButton name="Vende" to="propiedad/registro" />
      <NavButton name="Explora" to="propiedades" />
      <NavButton name={!inSession ? 'Iniciar Sesión' : 'Cerrar Sesión'} to={inSession === false ? 'login' : 'logout'} />
    </ul>
  );
};
