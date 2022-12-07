import { Link } from "react-router-dom";
import { Header } from "../components/Header"
import { Navbar } from "../components/NavBarLeo/Navbar";
import { SearchBar } from "../components/SearchBar"
import '../styles/home.css'

export const Home = () => {
  return (
    <>
    <div className="home-container">
    <Navbar/>
      <div className="d-flex flex-column contenedor-home">
        <div className="d-flex algin-items-center flex-column m-auto">
          <h2 className="h1 texto fw-bold text-white text-center">
            Gestiona tu alquiler de forma óptima
          </h2>
          <SearchBar />
        </div>
      </div>
      </div>
    </>
  );
}
