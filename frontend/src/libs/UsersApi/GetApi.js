import axios from "axios";

export function getUserByEmail(email) {
    return axios.get(`/api/v1/user/email/${email}`);
}

export function getUserById(id) {
    return axios.get(`/api/v1/user/${id}`);
}

export function getAllUsers() {
    return axios.get('/api/v1/user');
}