import axios from "axios";

export function deleteUser(id) {
    return axios.delete(`/api/v1/user/${id}`);
}
