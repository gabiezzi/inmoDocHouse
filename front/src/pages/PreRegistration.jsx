import React from 'react'
import { Navbar } from '../components/NavBarLeo/Navbar';
import '../styles/Preregistro.css';

export const PreRegistration = () => {
  return (
    <>
    <Navbar/>
      <div className='contenedor-preregistro d-flex align-items-center justify-content-center'>
        <div className='d-flex  align-items-center justify-content-center flex-column flex-lg-row flex-sm-row'>
          <button className='btn btn-lg btn-primary border border-light shadow-lg fw-bold mx-5 h1 p-4 my-4'>
           Soy Inmobiliaria
           </button>
          <button className='btn btn-lg btn-primary border border-light shadow-lg fw-bold mx-5 h1 p-4 my-4'>
            Soy Propietario
          </button>
        </div>
      </div>
    </>
  )
}
