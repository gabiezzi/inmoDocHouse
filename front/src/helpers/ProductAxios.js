import axios from "axios";

export const getAll = async()=>{
    const { data } = await axios.get('http://localhost:8080/property/getAll'); 
    return data;
}

export const getPropertyByAmbiences = async(quantity) => {
    const { data } = await axios.get(`http://localhost:8080/property/ambiences/${quantity}`);
    return data;
}

export const saveProperty = async(property) => {
    const { data } = await axios.post('http://localhost:8080/property/save', property);
    return data;
} 

export const deleteProperty = async(id) => {
    const res = await axios.delete(`http://localhost:8080/property/delete/${id}`);
}

export const changeProperty = async(property) => {
    const {id} = property;
    delete property.id;
    const res = await axios.put(`http://localhost:8080/property/update/${id}`, property);
    return res;
}

export const getPropertyByUbication = async(ubication) => {
    const property = await axios.get(`http://localhost:8080/property/ubication/${ubication}`);
    return property;
}

export const filteredProperty = async({quantity, typeOperation, ubication}) => {
    const { data } = await axios.get(`http://localhost:8080/property/filtered/?quantity=${quantity}&typeOperation=${typeOperation}&ubication=${ubication}`);
    return data;
    
}

export const findByQuantityOfAmbiences = async(quantity) => {
    const { data } = await axios.get(`http://localhost:8080/property/ambiences/${quantity}`);
    return data;
}

export const findByTypeOperation = async(typeOperation) => {
    const { data } = await axios.get(`http://localhost:8080/property/typeoperation/${typeOperation}`);
    return data;
}
