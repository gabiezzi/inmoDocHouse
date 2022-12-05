import React, { useEffect, useReducer } from 'react'
import { useContext } from 'react'
import { deleteProperty, filteredProperty, getAll, getPropertyByAmbiences, getPropertyByUbication, findByTypeOperation, findByQuantityOfAmbiences, saveProperty } from '../../helpers/ProductAxios'
import { TYPES } from '../types'
import { UserContext } from '../user/UserContext'
import { ProductContext } from './ProductContext'
import { productReducer } from './productReducer'

export const ProductState = ({children}) => {

  const {token} = useContext(UserContext);

  const initialState = {
    products: [],
    isLoading: true,
    productsFiltered: [],
    productSelected: null
  }

  const [state, dispatch] = useReducer( productReducer, initialState );

  useEffect(() => {
    getProducts();
  }, []);

  const resetFiltered = ()=> {
    dispatch({
      type: TYPES.RESET_SELECTED,
      payload: null
    })
  }
  
  const getProducts = async() => {
    const products = await getAll();
    dispatch({
      type: TYPES.PROPERTY_GET_ALL,
      payload: products
    })
  }

  const getPropertyByAmb = async(quantity) =>{
    const property = await getPropertyByAmbiences(quantity);
    dispatch({
      type: TYPES.GET_PROPERTY_BY_AMBIENCE,
      payload: property
    })
  }

  const propertySave = async(property) => {

    const prop = await saveProperty(property, token);
    dispatch({
      type: TYPES.SAVE_PROPERTY,
      payload: prop
    })
  }

  const deleteById = async(id) => {
     const res = deleteProperty(id);
     dispatch({
      type: TYPES.DELETE_PRODUCT,
      payload: id
     })
  }
  
  const changeProperty = (property) => {
    dispatch({
      type: TYPES.CHANGE_PROPERTY,
      payload: property
    });
  }

  const findByUbication = async(ubication) => {
    const {data} = await getPropertyByUbication(ubication);
    dispatch({
      type: TYPES.FIND_BY_UBICATION,
      payload: data
    });
  }

  const homeFilter = async(property) => {
    const {data} = await filteredProperty(property);
    dispatch({
      type: TYPES.FILTERED_PROPERTY,
      payload: data   
    })
  }

  const findByTypeOp = async(type) => {
    const data = await findByTypeOperation(type);
    dispatch({
      type: TYPES.FIND_BY_TYPE_OPERATION,
      payload: data   
    })
  }

  const findByQuantityOfAmb = async(quantity) => {
    const data = await findByQuantityOfAmbiences(quantity);
    dispatch({
      type: TYPES.FIND_BY_QUANTITY,
      payload: data   
    })
  }
    
  return (
    <ProductContext.Provider value={{
      products: state.products,
      isLoading: state.isLoading,
      productsFiltered: state.productsFiltered,
      productSelected: state.productSelected,
      getPropertyByAmb,
      propertySave,
      deleteById,
      changeProperty,
      resetFiltered,
      findByUbication,
      homeFilter,
      findByQuantityOfAmb,
      findByTypeOp
    }}>
        {children}
    </ProductContext.Provider>
  )
}
