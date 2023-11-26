import axios from "axios";

export async function deleteUser(id) {
    return await axios.delete(`http://localhost:8080/api/v1/user/${id}`);
}
