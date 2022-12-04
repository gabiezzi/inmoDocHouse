import axios from "axios";
import { AuthHeader } from "./AuthHeader";

export const getAll = async()=>{
    const { data } = await axios.get('http://localhost:8080/api/property/getAll'); 
    return data;
}

export const getPropertyByAmbiences = async(quantity) => {
    const { data } = await axios.get(`http://localhost:8080/api/property/ambiences/${quantity}`);
    return data;
}

export const saveProperty = async(property) => {
    const headers = { headers : AuthHeader() }
    console.log(headers);
    // const { data } = await axios.post('http://localhost:8080/api/property/save', property, headers);
    return property;
} 

export const deleteProperty = async(id) => {
    const res = await axios.delete(`http://localhost:8080/api/property/delete/${id}`);
}

export const changeProperty = async(property) => {
    const {id} = property;
    delete property.id;
    const res = await axios.put(`http://localhost:8080/api/property/update/${id}`, property);
    return res;
}

export const getPropertyByUbication = async(ubication) => {
    const property = await axios.get(`http://localhost:8080/api/property/ubication/${ubication}`);
    return property;
}

export const filteredProperty = async({quantity, typeOperation, ubication}) => {
    const { data } = await axios.get(`http://localhost:8080/api/property/filtered/?quantity=${quantity}&typeOperation=${typeOperation}&ubication=${ubication}`);
    return data;
    
}

export const findByQuantityOfAmbiences = async(quantity) => {
    const { data } = await axios.get(`http://localhost:8080/api/property/ambiences/${quantity}`);
    return data;
}

export const findByTypeOperation = async(typeOperation) => {
    const { data } = await axios.get(`http://localhost:8080/api/property/typeoperation/${typeOperation}`);
    return data;
}
