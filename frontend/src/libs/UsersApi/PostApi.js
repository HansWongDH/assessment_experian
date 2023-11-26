import axios from "axios";

export async function createUser(user) {
    return await axios.post('http://localhost:8080/api/v1/user', user);
}