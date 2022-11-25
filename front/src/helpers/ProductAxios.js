import axios from "axios";

export const getAll = async()=>{
    const {data} = await axios.get('http://localhost:8000/property/getAll'); 
    return data;
}

export const getPropertyByAmbiences = async(quantity) => {
    const {data} = await axios.get(`http://localhost:8000/property/ambiences/${quantity}`);
    return data;
}

export const saveProperty = async(property) => {

    const res = await fetch('http://localhost:8000/property/save',{
    method:"POST",
    headers:{
        'Access-Control-Allow-Origin': 'http://localhost:5173',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(property),
    mode:'cors'})
    return res.json();
} 

export const deleteProperty = async(id) => {
    const res = await fetch(`http://localhost:8000/property/${id}`, {
        method: 'DELETE',
        headers:{'Access-Control-Allow-Origin': 'http://localhost:5173'}
    });
    return res;   
}

export const changeProperty = async(property) => {
    const {id} = property;
    delete property.id;
    const res = await axios.put(`http://localhost:8000/property/${id}`, property);
    return res;
}

export const getPropertyByUbication = async(ubication) => {
    const property = await axios.get(`http://localhost:8000/property/ubication/${ubication}`);
    return property;
}

export const filteredProperty = async({quantity, typeOperation, ubication}) => {
    const res = await axios.get(`http://localhost:8000/property/filtered/?quantity=${quantity}&typeOperation=${typeOperation}&ubication=${ubication}`);
    return res.data;
    
}

export const findByQuantityOfAmbiences = async(quantity) => {
    const res = await axios.get(`http://localhost:8000/property/ambiences/${quantity}`);
    return res.data;
}

export const findByTypeOperation = async(typeOperation) => {
    const res = await axios.get(`http://localhost:8000/property/typeoperation/${typeOperation}`);
    return res.data;
}

export const saveUser = async(user) => {
    const res = await axios.post(`http://localhost:8000/user/create`, user);
    return res.data;
}