import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { NavLogin } from '../components/NavLogin';
import '../styles/forgotPassword.css';

export const ForgotPassword = () => {

    const navigate = useNavigate();

    const {register, formState:{errors}, handleSubmit, reset} = useForm({defaultValues:{
        email:'',
    }})

    const onSubmit = ({email}) => {
        console.log(email);
        reset();
        navigate('/login')
    }
  return (
    <>
    <NavLogin/>
    <div className='recuperar-password-contenedor d-flex flex-column justify-content-between align-items-center '>
        <div className='d-flex flex-column shadow col-10 col-sm-6 col-lg-4 px-4 m-auto bg-white rounded' >
            <h2 className='fw-bold text-center mt-5'>¿Olvidaste tu contraseña?</h2>
            <div>
                <p className='text-muted text-center'>Lo entendemos, ¡simplemente ingrese su dirección de correo electrónico a continuacion y le enviaremos un enlace para restablecer su contraseña!</p>
            </div>
            <form className='col-12 col-sm-8 col-lg-8 m-auto' onSubmit={handleSubmit(onSubmit)}>
                <input type="text" placeholder='Ingresa tu correo electronico' className='form-control my-2' {...register('email',{required: true})} />
                {errors.email?.type === 'required' && <p className='alert alert-danger'>Debe ingresar un correo electronico</p> }
                <button type='submit' className='btn btn-primary form-control mb-5'>Recuperar contraseña</button>
            </form>
        </div>
    </div>
    </>
  )
}