import './App.css'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '../node_modules/bootstrap/dist/js/bootstrap.min.js'
import { ProductPage } from './pages/ProductPage'
import { ProductState } from './context/product/ProductState'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { NotFoundPage } from './pages/NotFoundPage'
import { ProductsFiltered } from './pages/ProductsFiltered'
import { Home } from './pages/Home'
import { AddProduct } from './components/AddProduct'
import { Login } from './pages/Login'
import { Registration } from './pages/Registration'
import { ForgotPassword } from './pages/ForgotPassword'
import { UserState } from './context/user/UserState'

function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <ProductState>
          <UserState>
            <Routes>
              <Route path='/propiedades' element={ <ProductPage/> } />
              <Route path='/filtros' element={ <ProductsFiltered/> } />
              <Route path='/' element={ <Home/> } />
              <Route path='/propiedad/registro'element={ <AddProduct/> } />
              <Route path='*' element={ <NotFoundPage/> } />
              <Route path='/login' element={ <Login/> } />
              <Route path='/registro' element={ <Registration/>} />
              <Route path='/recuperar' element={ <ForgotPassword/> } />
            </Routes>
          </UserState>
        </ProductState>
      </BrowserRouter>
    </div>
  )
}

export default App
