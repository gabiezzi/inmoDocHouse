import { useForm } from 'react-hook-form'
import '../styles/searchBar.css'
import { useContext } from 'react';
import { ProductContext } from '../context/product/ProductContext';
import { useNavigate } from 'react-router-dom';
export const SearchBar = () => {

  const navigate = useNavigate();

  const {homeFilter, findByTypeOp, findByQuantityOfAmb, findByUbication} = useContext( ProductContext );

  const {register, reset, handleSubmit } = useForm({defaultValues: {
    ubication:'',
    typeOperation:'',
    quantityOfBedrooms:''
  }});

  const onSubmit = (property) => {
    if(property.typeOperation === '' && property.quantityOfBedrooms === '') {
      findByUbication(property.ubication);
      reset();
      navigate('/filtros');
    }else if(property.ubication === '' && property.typeOperation === ''){
      findByQuantityOfAmb(property.quantityOfBedrooms);
      reset();
      navigate('/filtros');

    }else if(property.ubication === '' && property.quantityOfBedrooms === ''){
      findByTypeOp(property.typeOperation);
      reset();
      navigate('/filtros');      
    }else{
      homeFilter(property);
      reset();
      navigate('/filtros');
    }
  

  }

  return (
    <>
        <form className='d-flex w-100 flex-column flex-sm-row flex-lg-row form-searchbar align-items-center' onSubmit={handleSubmit(onSubmit)}>
            <input type="text" placeholder='Busca por ciudad o zonas' className='form-control rounded-start' {...register('ubication', {required:false})}/>
            <select className='form-select text-center my-2' {...register('typeOperation',{required: false})} defaultValue='Operacion'>
              <option value="">Operacion</option>
              <option value="Rental">Alquiler</option>
              <option value="Sale">Venta</option>
            </select>
            <select className='form-select text-center' {...register('quantityOfBedrooms', {required: false })} defaultValue='Habitaciones'>
              <option value="">Habitaciones</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
            </select>
            <button className='btn btn-info fw-bold my-2 rounded-end'>Buscar</button>
        </form>
    </>
  )
}
