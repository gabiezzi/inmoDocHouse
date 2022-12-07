import { useContext } from "react"
import { FilterProduct } from "../components/FilterProduct"
import { Header } from "../components/Header"
import { Navbar } from "../components/NavBarLeo/Navbar"
import { Product } from "../components/Product"
import { ProductContext } from "../context/product/ProductContext"
import { departamentos } from "../data/departamentos"
import '../styles/productPage.css'

export const ProductPage = () => {
  
  const {products, isLoading} = useContext(ProductContext)

  
  return (
    <>
    <Navbar/>
    <div className="d-flex col-12 flex-column flex-sm-row flex-lg-row flex-wrap">
      <div className="filter-product-page col-12 col-sm-5 col-lg-3 text-center bg-body">
        <FilterProduct/>
      </div>
      <div className="items col-12 col-sm-7 col-lg-9 d-flex flex-column align-items-center">
      {
        isLoading && <p className="text-center fw-bold">Cargando...</p>
      }
      {
        products.length === 0 && <span className="alert alert-info">No hay propiedades..</span>
      }
        {products.map((item, i) => <Product key={item.id} item={item} imagen={departamentos[i].imagen}  />)}
      </div>
    </div>
    </>
  )
}
