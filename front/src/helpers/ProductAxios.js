import axios from "axios";


export const getAll = async()=>{
    const { data } = await axios.get('http://localhost:8080/api/property/getAll'); 
    return data;
}

export const getPropertyByAmbiences = async(quantity) => {
    const { data } = await axios.get(`http://localhost:8080/api/property/ambiences/${quantity}`);
    return data;
}

export const saveProperty = async(property, token) => {

    const config = {
        url: 'http://localhost:8080/api/property/save',
        method:'POST',
        headers: { 
            'Authorization': token,
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Headers': 'POST, GET, PUT, DELETE, OPTIONS, HEAD, Authorization, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Origin',
            'Content-Type': 'application/json',
        },
        data: JSON.stringify(property)
    }
    const { data } = await axios(config);
    return data;
} 

export const deleteProperty = async(id, token) => {
    const config = {
        url:`http://localhost:8080/api/property/delete/${id}`,
        method: 'DELETE',
        headers: {
        'Authorization': token,
        }
    }
    const res = await axios(config);
}

export const changeProperty = async(property, token) => {
    const {id} = property;
    delete property.id;
    const config = {
        url:`http://localhost:8080/api/property/update/${id}`,
        method: 'PUT',
        headers: {
            'Authorization': token,
           'Content-Type': 'application/json',
        },
        data: JSON.stringify(property)
    }
    const res = await axios(config);
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

export const findByMaxPrice = async(price)=> {
    const {data} = await axios.get(`http://localhost:8080/api/property/pricemin/${price}`);
    return data;
}
