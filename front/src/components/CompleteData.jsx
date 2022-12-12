import React from 'react'
import { SideBar } from './SideBar'
import '../styles/completeData.css'
export const CompleteData = () => {
  return (
    <>
    <div className='d-flex'>
    <SideBar/>
        <div className='d-flex justify-content-center align-items-center col-9 form-contenedor'>
            <form className='form w-50 bg-white p-4 rounded shadow'>
                <div>
                    <label className='form-label'>Nombre</label>
                    <input type="text" className='form-control' />
                </div>
                <div>
                    <label className='form-label'>Apellido</label>
                    <input type="text" className='form-control' />
                </div>
                <div>
                    <label className='form-label'>Dni</label>
                    <input type="text" className='form-control' />
                </div>
                <div>
                    <label className='form-label'>Fecha de nacimiento</label>
                    <input type="date" className='form-control' />
                </div>
                <button className='btn mt-2 btn-outline-success'>Guardar</button>
            </form>
        </div>
    </div>
    </>
  )
}
