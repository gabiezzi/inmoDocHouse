import React from 'react'
import { Logo } from './Logo'
import { NavbarMobile } from './NavBar/NavbarMobile'
import { Navbar } from './NavBar/Navbar'
import '../styles/header.css'




export const Header = () => {
  return (
    <div className=' Header d-flex col-12'>
      <Logo />
      <Navbar />
      <NavbarMobile />
    </div>
  )
}
