import React, { useContext, useState } from "react";
import "../styles/profile.css";
import { SideBar } from "../components/SideBar";

export const Profile = () => {

  return (
    <>
      <div className="d-flex">
        <SideBar />
        <div className='w-75 contenido-sidebar d-flex justify-content-center align-items-center flex-column'>
            <h2 className="fw-bold display-5">Mr House</h2>
            <p className="text-center">Administra tus propiedades</p>
        </div>
      </div>
      
    </>
  );
};
