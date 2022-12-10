import axios from "axios"


export const signin = async(user) => {
    const res = await axios.post('http://localhost:8080/api/auth/signin', user);
    console.log(res.data);
}

export const login = async(user) => {
    try {
        const { usernameOrEmail } = user
        const {data} = await axios.post('http://localhost:8080/api/auth/login', user);
        const userRegistred = {
            usernameOrEmail,
            token:data.accessToken
        }
        window.localStorage.setItem('user', JSON.stringify(userRegistred));
        return userRegistred;
    } catch (error) {
        throw new Error(error);
    }

}

