import axios from "axios";

export async function updateUser(id, userDto) {
    return await axios.put(`http://localhost:8080/api/v1/user/${id}`, userDto);
}