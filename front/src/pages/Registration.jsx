import { useForm } from 'react-hook-form'
import { Link, useNavigate } from 'react-router-dom'
import { NavLogin } from '../components/NavLogin'
import '../styles/registration.css'
export const Registration = () => {

  const navigate = useNavigate();

  const { register, formState:{errors}, reset, handleSubmit, getValues, setFocus } = useForm({defaultValues:{
    username:'',
    email:'',
    password:'',
  }});

  const onSubmit = (user) => {
    reset();
    navigate('/login');
  }


  return (
    <>
      <NavLogin />
      <div className="d-flex flex-column flex-lg-row flex-sm-row align-items-center justify-content-around registro-contenedor">
        <div className="col-12 col-sm-6 col-lg-6">
          <h2 className="text-center">Registrate</h2>
        </div>
        <div className="col-12 col-sm-6 col-lg-6 d-flex justify-content-center align-items-center">
          <form className="w-75" onSubmit={handleSubmit(onSubmit)}>
            <div>
              <label className="form-label">Nombre de usuario</label>
              <input type="text" name="" id="" className="form-control" {...register('username', {required: true})} />
              {errors.username?.type === 'required' && <p className='alert alert-danger'>El campo usuario es requerido</p> }
            </div>
            <div>
              <label className="form-label">Email</label>
              <input type="email" name="" id="" className="form-control" {...register('email', {required: true})} />
              {errors.email?.type === 'required' && <p className='alert alert-danger'>El campo email es requerido</p> }
            </div>
            <div>
              <label className="form-label">Contraseña</label>
              <input type="password" name="" id="" className="form-control" {...register('password', {required: true})} />
              {errors.password?.type === 'required' && <p className='alert alert-danger'>El campo contraseña es requerido</p> }
            </div>
            <div className="mt-2">
                <button className="btn btn-success" type="submit">
                    Guardar
                </button>
                <Link to="/" className="text-white text-decoration-none btn btn-primary mx-2">
                  Volver
                </Link>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}
