import React, { useContext, useEffect, useState } from 'react'
import { BsShare, BsFillHeartFill } from "react-icons/bs";
import { GrLocation } from "react-icons/gr";
import { FaBed, FaToilet, FaRegEdit} from "react-icons/fa";
import { MdPhotoSizeSelectSmall, MdDelete } from "react-icons/md";
import '../styles/product.css'
import { ProductContext } from '../context/product/ProductContext';
import { Link } from 'react-router-dom';
import { UserContext } from '../context/user/UserContext';

export const Product = ({item, imagen}) => {
    const {deleteById, changeProperty} = useContext(ProductContext); 
    const [isClicked, setIsCliked] = useState(false);
    const [color, setcolor] = useState('');
    const changeColor = () => {
        setIsCliked(!isClicked);
        isClicked ? setcolor('red') : setcolor('');
    }


  return (
    <>
        <div className='border rounded d-flex card target mb-2' style={{maxWidth: '540px'}}>
            <div className='row g-0'>
                <div className='col-md-4'>
                    <img src={imagen} alt="..." className='imagen rounded-start'/>
                </div>
                <div className='col-md-8'>
                    <div className='card-body'>
                        <div className='d-flex justify-content-around align-items-center mb-2'>
                            <div className='text-muted description'>En Alquiler</div>
                            <div className='text-muted description'>Nuevo</div>
                            <button className='boton'>
                                <BsShare />
                            </button>
                            <button onClick={ ()=> changeColor() } className="boton">
                                <BsFillHeartFill className={`${color}`} />
                            </button>

                            {

                            }
                            <button className='boton' onClick={()=> changeProperty(item) }>
                                <Link to='/propiedad/registro'>
                                    <FaRegEdit/>
                                </Link>
                            </button>
                            <button className='boton' onClick={()=>deleteById(item.id) }>
                                <MdDelete/>
                            </button>
                        </div>
                        <p className='card-title text-center '>{item.typeOperation}</p>
                        <div className='d-flex align-items-center justify-content-center'>
                            <GrLocation/>
                            <div className='mx-2 my-2 description'>{item.ubication}</div>
                        </div>
                        <p className='fw-bold h5 text-success text-center'>${item.price}</p>
                        <div className='d-flex justify-content-around'>
                            <div>
                                <FaBed className='mx-2'/>
                                {item.quantityOfAmbiences}
                            </div>
                            <div>
                                <FaToilet className='mx-2'/>
                                {item.quantityOfBathrooms}
                            </div>
                            <div>
                                <MdPhotoSizeSelectSmall className='mx-2'/>
                                {item.m2} m²
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </>
  )
}
