import axios from "axios";

export function getUserByEmail(email) {
    return axios.get(`http://localhost:8080/api/v1/user/email/${email}`);
}

export function getUserById(id) {
    return axios.get(`http://localhost:8080/api/v1/user/${id}`);
}

export function getAllUsers() {
    return axios.get('http://localhost:8080/api/v1/user');
}