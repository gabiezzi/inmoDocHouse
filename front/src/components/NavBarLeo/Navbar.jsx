import React from 'react'
import { useContext } from 'react'
import { GiHouse } from 'react-icons/gi'
import { Link } from 'react-router-dom'
import { UserContext } from '../../context/user/UserContext'
import './Navbar.css'

export const Navbar = () => {

  const { inSession, logout, login } = useContext(UserContext);
  const textButton = inSession ? 'Cerrar Sesión':'Iniciar Sesión';
  const accion = inSession ? logout : login;

  return (
    <>
<nav className="navbar navbar-expand-lg bg-light shadow">
    <div className="container-fluid ">
        <Link to='/' className='text-decoration-none d-flex justify-content-center align-items-center'>
            <GiHouse size="40px" />
            <p className='m-2 text-dark fw-bolder'>DocHouse</p>
        </Link>

        <button className="navbar-toggler burguer" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse " id="navbarNav">
            <ul className="navbar-nav text-center d-flex flex-column flex-lg-row w-100 justify-content-end">
                <li className="nav-item mx-3 my-2">
                  <Link to='/alquila' className='text-decoration-none text-dark'>Alquila</Link>
                </li>

                <li className="nav-item mx-3 my-2">
                  <Link to='/propiedad/registro' className='text-decoration-none text-dark'>Vende</Link>
                </li>

                <li className="nav-item mx-3 my-2">
                  <Link to='/propiedades' className='text-decoration-none text-dark'>Explora</Link>
                </li>

                <li className="nav-item">
                    <button className='btn fw-bold' onClick={accion}>
                      {textButton}
                    </button>
                </li>
            </ul>
        </div>
    </div>
</nav>
    </>
  )
}
