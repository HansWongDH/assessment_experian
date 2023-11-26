import axios from "axios";

export function updateUser(id, userDto) {
    return axios.put(`/api/v1/user/${id}`, userDto);
}