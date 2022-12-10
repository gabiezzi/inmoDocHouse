import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import { Link, useNavigate } from 'react-router-dom'
import { NavLogin } from '../components/NavLogin'
import '../styles/login.css'
import { useContext } from 'react'
import { UserContext } from '../context/user/UserContext'

export const Login = () => {

  const [invalidPass, setInvalidPass] = useState(false);

  const { userLogin } = useContext(UserContext);
  const navigate = useNavigate();

  const { register, formState:{errors}, handleSubmit, reset } = useForm({defaultValues: {
    usernameOrEmail: '',
    password: ''
  }});

  const onSubmit = (user)=> {
    try {
      
      userLogin(user);
      reset();
      navigate('/propiedades')

    } catch (error) {
      console.log('hago lo que quiero')
      reset();
      setInvalidPass(true);
      setTimeout(() => {
        setInvalidPass(true);
        }, 3000);
    }
  }

  return (
    <>
      <NavLogin />
      <div className=" form-login d-flex align-items-center justify-content-center">
        <div className="col-10 col-sm-6 col-lg-4 py-5 px-5 shadow border border-ligth rounded bg-white">
          <h2 className="text-center fw-bold">Iniciar Sesión</h2>
          <hr />
          <form onSubmit={handleSubmit(onSubmit)}>
            <div>
              <label className="form-label">Usuario</label>
              <input type="text" placeholder='Ingrese usuario o email' className="form-control" {...register('usernameOrEmail', { required: true })} />
              {errors.usernameOrEmail?.type === 'required' && <p className='alert alert-danger'>Debe ingresar el usuario</p> }
            </div>
            <div className="my-4">
              <label className="form-label">Contraseña</label>
              <input type="password" placeholder='Ingrese su contraseña' className="form-control" {...register('password', { required: true })}/>
              { errors.password?.type === 'required' && <p className='alert alert-danger'>Debe ingresar la contraseña</p> }
              { invalidPass && <p className='alert alert-danger>'>Usuario o contraseña incorrectos</p> }
            </div>
            <div>
              <button className="btn btn-primary form-control">
                Iniciar Sesión
              </button>
            </div>
            <div className="d-flex justify-content-center mt-2">
              <div className='d-flex flex-column'>
                <div className='text-center small'>
                ¿No estas registrado? <Link to="/registro" className='text-decoration-none'>Registrate</Link>
                </div>
                <Link to='/recuperar' className='small text-decoration-none text-center'>¿Olvidaste tu contraseña?</Link>
              </div>
            </div>
          </form>
        </div>
      </div>
      
    </>
  );
}
