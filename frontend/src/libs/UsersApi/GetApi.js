import axios from "axios";

export async function getUserByEmail(email) {
    return await axios.get(`http://localhost:8080/api/v1/user/email/${email}`);
}

export async function getUserById(id) {
    return await axios.get(`http://localhost:8080/api/v1/user/${id}`);
}

export async function getAllUsers() {
    return await axios.get('http://localhost:8080/api/v1/user');
}