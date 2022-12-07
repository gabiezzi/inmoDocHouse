import { useNavigate } from 'react-router-dom';

export const Logout = () => {
    const navigate = useNavigate();

    const userLogout = () => {
        setTimeout(() => {
            navigate("/");
        }, 1500);
    }

    userLogout();

  return (
    <>
        <div className='col-12 d-flex justify-content-center align-items-center'>
            <span className='alert alert-success w-50 text-center'>
                Gracias por usar nuestros servicios
            </span>
        </div>
    </>
  )
}
