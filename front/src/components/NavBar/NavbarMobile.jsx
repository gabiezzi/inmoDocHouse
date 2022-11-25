import { NavLinks } from "./NavLinks"
import './Navbar.css';
import { RiMenuFill } from 'react-icons/ri'
import { CgCloseR } from 'react-icons/cg'
import { useState } from "react";


export const NavbarMobile = () => {

    const [open, setOpen] = useState(false);

    const hamburgerItem = < RiMenuFill className="Hamburger" size="40px" color="black" onClick={()=> setOpen(!open)}/>

    const CloseItem = < CgCloseR className="Hamburger" size="30px" color="black" onClick={()=> setOpen(!open)}/>

    const closeMobileMenu = () => setOpen(false);
    return (
        <nav className="NavbarMobile">
            {open ? CloseItem : hamburgerItem  }
            {open && <NavLinks isMobile={true} closeMobileMenu={closeMobileMenu}/>}
        </nav>
    )
}
