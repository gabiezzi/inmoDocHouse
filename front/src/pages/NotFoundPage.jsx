import React from "react";
import { NavLink } from 'react-router-dom'

export const NotFoundPage = () => {
  return (
    <div className="d-flex col-12 justify-content-around align-items-center flex-column">
      <div className="text-center col-10 col-sm-8 col-lg-6 alert alert-danger">
        <p>Pagina no encontrada</p>
      </div>
      <NavLink to="/" className="btn btn-dark">
        Volver al inicio
      </NavLink>
    </div>
  );
};
