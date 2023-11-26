import { TableRow, TableCell, Link } from '@mui/material';
import { deleteUser } from '../libs/UsersApi/DeleteApi';
import { useState } from 'react';
import ConfirmationPrompt from '../libs/utils/confirmationPrompt';

const UserTableRow = ({ user }) => {
	const [isConfirmationOpen, setConfirmationOpen] = useState(false);
	const handleEditClick = (e) => {
	  e.preventDefault();
	};
  
	const handleDeleteClick = (e) => {
		e.preventDefault();
		setConfirmationOpen(true);
	  };

	const handleConfirmDelete = () => {
		deleteUser(user.id);
		setConfirmationOpen(false);
	  };
	
	  const handleCloseConfirmation = () => {
		setConfirmationOpen(false);
	  };
  
	return (
	  <TableRow key={user.id}>
		<TableCell>{user.id}</TableCell>
		<TableCell>
		  <Link href={`link-to-user-profile/${user.id}`}>{user.email}</Link>
		</TableCell>
		<TableCell>{user.firstName}</TableCell>
		<TableCell>{user.lastName}</TableCell>
		<TableCell>
		  <Link href="#" onClick={handleEditClick}>
			Edit
		  </Link>
		</TableCell>
		<TableCell>
		  <Link href="#" onClick={handleDeleteClick}>
			Delete
		  </Link>
		</TableCell>
		<ConfirmationPrompt
        open={isConfirmationOpen}
        onClose={handleCloseConfirmation}
        onConfirm={handleConfirmDelete}
        message={`Are you sure you want to delete user ${user.id}?`}
      />
	  </TableRow>
	);
  };

  export default UserTableRow;