import axios from "axios"


export const signin = async(user) => {
    const res = await axios.post('http://localhost:8080/api/auth/signin', user);
    console.log(res.data);
}

export const login = async(user) => {
    try {
        const {data} = await axios.post('http://localhost:8080/api/auth/login', user); 
        window.localStorage.setItem('user', JSON.stringify(data));
        return data;
    } catch (error) {
        throw new Error(error);
    }

}

