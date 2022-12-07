import React from 'react'
import { GiHouse } from 'react-icons/gi'
import { Link } from 'react-router-dom'

export const Logo = () => {
  return (
    <Link to='/' className='container d-flex justify-content-center align-items-center w-100 text-decoration-none'>
      <GiHouse size="40px" color="black"  />
      <p className='m-2 text-dark fw-bolder'>DocHouse</p>
    </Link>
  )
}