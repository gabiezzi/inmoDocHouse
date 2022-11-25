import { Link } from 'react-router-dom';
import { NavButton } from './NavButton.jsx'

export const NavLinks = () => {
  return (
    <ul className="NavLinks">
      <NavButton name="Alquila" to="alquila" />
      <NavButton name="Vende" to="propiedad/registro" />
      <NavButton name="Explora" to="propiedades" />
      <NavButton name="Iniciar Sesión" to="login" />
    </ul>
  );
};
