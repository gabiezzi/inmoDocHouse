import './App.css'
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
import { Profile } from './pages/Profile'
import { PreRegistration } from './pages/PreRegistration'
import { CompleteData } from './components/CompleteData'
import { Propiedades } from './components/Propiedades'
import { Turnos } from './pages/Turnos'

function App() {


  return (
    <div className="App">
      <BrowserRouter>
        <UserState>
          <ProductState>
            <Routes>
              <Route path='/propiedades' element={ <ProductPage/> } />
              <Route path='/filtros' element={ <ProductsFiltered/> } />
              <Route path='/' element={ <Home/> } />
              <Route path='/propiedad/registro'element={ <AddProduct/> } />
              <Route path='*' element={ <NotFoundPage/> } />
              <Route path='/login' element={ <Login/> } />
              <Route path='/registro' element={ <Registration/>} />
              <Route path='/recuperar' element={ <ForgotPassword/> } />
              <Route path='/perfil' element={ <Profile/> } />
              <Route path='/preregistro' element={ <PreRegistration/> } />
              <Route path='/completar' element={ <CompleteData/> } />
              <Route path='/propiedades/administrar' element={ <Propiedades/> }/>
              <Route path='/turnos' element={ <Turnos/> } />
            </Routes>
          </ProductState>
        </UserState>
      </BrowserRouter>
    </div>
  )
}

export default App
