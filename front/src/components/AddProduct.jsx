import { useContext, useEffect } from 'react';
import { useForm } from 'react-hook-form'
import { Link, useNavigate } from 'react-router-dom';
import { ProductContext } from '../context/product/ProductContext';
import { changeProperty } from '../helpers/ProductAxios';
import '../styles/addProduct.css'

export const AddProduct = () => {

    const navigate = useNavigate();


    const { propertySave, productSelected, resetFiltered } = useContext(ProductContext);
    //ESTADO INICIAL DEL FORMULARIO
    const initialForm = {
        id: '',
        address:undefined ,
        m2:undefined ,
        quantityOfAmbiences:undefined,
        price:undefined,
        quantityOfBathrooms:undefined,
        garage: 2,
        expense:undefined,
        privateNeighborhood: 1,
        typeOperation: 'Sale',
        ubication: ''
    }
    //HOOK PARA MANEJAR EL FORM
    const {register, formState:{errors}, handleSubmit, reset, setValue } = useForm({defaultValues: initialForm});

    //FUNCION PARA MANEJAR EL SUBMIT
    const onSubmit = (property) => {
        if(productSelected){
            changeProperty(property);
            reset();
            resetFiltered();
            navigate('/propiedades')

        }else{
            propertySave(property);
            reset();
            navigate('/propiedades')
        }
    }

    //
    useEffect(() => {
      if(productSelected){
        setValue('id', productSelected.id);
        setValue('address', productSelected.address)
        setValue('m2', productSelected.m2);
        setValue('quantityOfAmbiences', productSelected.quantityOfAmbiences);
        setValue('price', productSelected.price);
        setValue('quantityOfBathrooms', productSelected.quantityOfBathrooms);
        setValue('expense', productSelected.expense);
        setValue('ubication', productSelected.ubication);
      }
    }, [productSelected])
    
  return (
    <>
        <div className='d-flex flex-column flex-sm-row flex-lg-row col-12'>
            <div className='col-12 col-sm-6 col-lg-6 d-flex align-items-center justify-content-center'>
                <h2 className='text-center'>Registre su inmueble</h2>
            </div>
            <div className='col-10 col-sm-6 col-lg-6 m-auto '>
                <div className='form-container'>
                    <form onSubmit={handleSubmit(onSubmit)}  className="w-75 container">
                    <input type="hidden" {...register('id', { required: false })} />
                    <div>
                        <label className='form-label'>m2</label>
                        <input type="number"  className='form-control' {...register('m2', {required: true})}/>
                        {errors.m2?.type === 'required' && <p className='alert alert-danger'>El campo m2 es requerido</p> }
                    </div>
                    <div>
                        <label className='form-label'>Direccion</label>
                        <input type="text"  className='form-control' {...register('address', {required: true})}/>
                        {errors.address?.type === 'required' && <p className='alert alert-danger'>El campo direccion es requerido</p> }
                    </div>
                    <div>
                        <label className='form-label'>Cantidad de habitaciones</label>
                        <input type="number" className='form-control'  {...register('quantityOfAmbiences', {required: true})}/>
                        {errors.quantityOfAmbiences?.type === 'required' && <p className='alert alert-danger'>La cantidad de habitaciones es requerida</p> }
                    </div>
                    <div>
                        <label className='form-label'>Precio</label>
                        <input type="number" className='form-control' {...register('price', {required: true})}/>
                        {errors.price?.type === 'required' && <p className='alert alert-danger'>El campo precio es requerido</p> }
                    </div>
                    <div>
                        <label className='form-label'>Cantidad de baños</label>
                        <input type="number" className='form-control' {...register('quantityOfBathrooms', {required: true})}/>
                        {errors.quantityOfBathrooms?.type === 'required' && <p className='alert alert-danger'>La cantidad de baños es requerido</p> }
                    </div>
                    <div>
                        <label className='form-label'>Expensas</label>
                        <input type="number" className='form-control' {...register('expense', {required: true})}/>
                        {errors.expense?.type === 'required' && <p className='alert alert-danger'>El campo expensas es requerido</p> }
                    </div>
                    <div>
                        <label className='form-label'>Ubicacion</label>
                        <input type="text" className='form-control' {...register('ubication', {required: true})}/>
                        {errors.ubication?.type === 'required' && <p className='alert alert-danger'>El campo ubicacion es requerido</p> }
                    </div>
                    <button type='submit' className='btn btn-success mt-2'>Registrar</button>
                    <button type='submit' className='btn btn-warning mt-2 mx-2'>
                        <Link to='/' className='text-decoration-none text-dark'>Volver</Link>
                    </button>
                    </form>
                </div>
            </div>
        </div>
    </>
  )
}
