import React, { useContext, useState } from 'react'
import { BsFillHouseDoorFill, BsBuilding,  } from "react-icons/bs";
import { BiBuilding, BiBuildingHouse } from "react-icons/bi";
import '../styles/filterProduct.css'
import { ProductContext } from '../context/product/ProductContext';
import { Link, useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';


export const FilterProduct = () => {

  const navigate = useNavigate();

  const [precio, setPrecio] = useState(20000);
  const handleChange = ({target})=> {
    const {value} = target;
    setPrecio(value);
  }
  const {register, reset, handleSubmit} = useForm({defaultValues:{location: ''}})
 
  const {getPropertyByAmb, findByUbication} = useContext(ProductContext);
  const onSubmitLocation = ({location}) => {
    findByUbication(location);
    reset();
    navigate('/filtros');
  }
  return (
    <>
      <div className="d-flex flex-column justify-content-center contenedor ">
        <div className="formulario d-flex flex-column align-items-center ">
          <h5 className="fw-bold my-2">Ubicación</h5>
          <form className="col-10 col-sm-10 col-lg-8" onSubmit={handleSubmit(onSubmitLocation)}>
            <input type="text" className="form-control" {...register('location', {required: false})}/>
          </form>
        </div>

        <div className="d-flex flex-column align-items-center my-3">
          <h5 className="fw-bold mb-3">Tipo de propiedad</h5>
          <div className="d-flex flex-column">
            <div className="d-flex justify-content-center">
              <button className="btn mx-2 col-6">
                <BsFillHouseDoorFill />
                <p>Casa</p>
              </button>
              <button className="btn mx-2 col-6">
                <BsBuilding />
                <p>Departamento</p>
              </button>
            </div>
            <div className='d-flex justify-content-center'>
              <button className="btn mx-2 col-6">
                <BiBuilding />
                <p>Proyecto</p>
              </button>
              <button className="btn mx-2 col-6">
                <BiBuildingHouse />
                <p>Lanzamiento</p>
              </button>
            </div>
          </div>
        </div>

        <div className="d-flex flex-column align-items-center">
          <h5 className='fw-bold'>Precios</h5>
          <p>Entre $20000 y $150000</p>
          <label>${precio}</label>
          <input type="range" min={20000} max={150000} onChange={handleChange}/>
        </div>

        <div className='d-flex flex-column align-items-center my-3'>
          <h5 className='fw-bold'>Habitaciones</h5>
          <div className='d-flex justify-content-around w-100 p-2'>
            <button className='boton-habitaciones ' onClick={()=> getPropertyByAmb(1)}>
              <Link to='/filtros' className='text-decoration-none text-secondary'>1</Link>
            </button>
            <button className='boton-habitaciones ' onClick={()=> getPropertyByAmb(2)}>
              <Link to='/filtros' className='text-decoration-none text-secondary'>2</Link>
            </button>
            <button className='boton-habitaciones ' onClick={()=> getPropertyByAmb(3)}>
              <Link to='/filtros' className='text-decoration-none text-secondary'>3</Link>
            </button>
            <button className='boton-habitaciones ' onClick={()=> getPropertyByAmb(4)}>
              <Link to='/filtros' className='text-decoration-none text-secondary'>4</Link>
            </button>
          </div>
        </div>
        
      </div>
    </>
  );
}
