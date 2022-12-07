import './Navbar.css';
import { Link } from 'react-router-dom';

export const NavButton = ({name, to}) => {

  return (
  
    <Link to={`/${to}`} className='NavLinkItem btn border-0 fw-bolder text-dark m-auto'>
        {name}
    </Link>
  )
}
