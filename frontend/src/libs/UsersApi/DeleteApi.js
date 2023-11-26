import axios from "axios";

export function deleteUser(id) {
    return axios.delete(`http://localhost:8080/api/v1/user/${id}`);
}
