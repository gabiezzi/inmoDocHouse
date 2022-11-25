import { TYPES } from "../types";
export const productReducer = (state, action) => {
  const { type, payload } = action;
  const { products } = state;

  switch (type) {
    case TYPES.PROPERTY_GET_ALL:
      return {
        ...state,
        products: payload,
        isLoading: false,
      };
    case TYPES.GET_PROPERTY_BY_AMBIENCE:
      return {
        ...state,
        productsFiltered: payload,
      };
    case TYPES.SAVE_PROPERTY:
      return {
        ...state,
        products: [...products, payload],
      };
    case TYPES.DELETE_PRODUCT:
      return {
        ...state,
        products: products.filter((item) => item.id !== payload),
      };
    case TYPES.CHANGE_PROPERTY:
      const product = products.find((item) => item.id === payload.id);
      return {
        ...state,
        productSelected: product,
      };
    case TYPES.RESET_SELECTED:
      return {
        ...state,
        productSelected: null,
      };
    case TYPES.FIND_BY_UBICATION:
      return {
        ...state,
        productsFiltered: payload,
      };
    case TYPES.FILTERED_PROPERTY:
      return {
        ...state,
        productsFiltered: payload,
      };
    case TYPES.FIND_BY_TYPE_OPERATION:
        return{
            ...state,
            productsFiltered: payload,       
        }
    case TYPES.FIND_BY_QUANTITY:
        return{
            ...state,
            productsFiltered: payload,
        }
    default:
      return state;
  }
};
