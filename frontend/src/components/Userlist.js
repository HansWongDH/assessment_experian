import React, { useEffect, useState } from 'react';
import { getAllUsers } from '../libs/UsersApi/GetApi';
import UserTableRow from './UserTableRow';

const UserList = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        getAllUsers()
            .then(response => setUsers(response.data))
            .catch(error => console.error('Error fetching users:', error));
    }, []);

    return (
        <div>
            <h2>User List</h2>
            <ul>
                {users.map(user => (
                    <UserTableRow user={user}></UserTableRow>
                ))}
            </ul>
        </div>
    );
};

export default UserList;