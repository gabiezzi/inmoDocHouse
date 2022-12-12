import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Navbar } from '../components/NavBarLeo/Navbar';
import '../styles/Preregistro.css';

export const PreRegistration = () => {

  const navigate = useNavigate();

  const registro = () => {
    navigate('/registro');
  }

  return (
    <>
    <Navbar/>
      <div className='contenedor-preregistro d-flex align-items-center justify-content-center'>
        <div className='d-flex  align-items-center justify-content-center flex-column flex-lg-row flex-sm-row'>
          <button onClick={registro} className='btn btn-lg btn-primary border border-light shadow-lg fw-bold mx-5 h1 p-4 my-4'>
           Quiero comprar
           </button>
          <button onClick={registro} className='btn btn-lg btn-primary border border-light shadow-lg fw-bold mx-5 h1 p-4 my-4'>
            Quiero vender
          </button>
        </div>
      </div>
    </>
  )
}
