import { TableRow, TableCell, Link } from '@mui/material';
import { deleteUser } from '../libs/UsersApi/DeleteApi';
import { useState } from 'react';
import ConfirmationPrompt from '../libs/utils/confirmationPrompt';
import UserForm from './UserForm';
import { updateUser } from '../libs/UsersApi/PutApi';

const UserTableRow = ({ user, refreshHandler }) => {
	const [isConfirmationOpen, setConfirmationOpen] = useState(false);
	const [isFormOpen, setFormOpen] = useState(false);


	//Delete function
	const handleDeleteClick = (e) => {
		e.preventDefault();
		setConfirmationOpen(true);
	  };

	const handleConfirmDelete = () => {
		
		try
		{
			deleteUser(user.id);
		}
		catch(error)
		{
			console.log(error);
		}
		refreshHandler();
		setConfirmationOpen(false);
	  };
	
	  const handleCloseConfirmation = () => {
		setConfirmationOpen(false);
	  };
  

	  //Edit and Update Function

	  const handleEditClick = (e) => {
		e.preventDefault();
		setFormOpen(true);
	  };

	  const handleSaveEditForm = (editedUser) => {
		try{
			updateUser(editedUser.id, editedUser)
		}
		catch(error){
			console.log(error);
		}
		refreshHandler();
		setFormOpen(false);
	  };
	
	  const handleCloseEditForm = () => {
		setFormOpen(false);
	  };
	return (
	  <TableRow key={user.id}>
		<TableCell>{user.id}</TableCell>
		<TableCell>{user.email}</TableCell>
		<TableCell>{user.firstName}</TableCell>
		<TableCell>{user.lastName}</TableCell>
		<TableCell>
		  <Link onClick={handleEditClick}>
			Edit
		  </Link>
		</TableCell>
		<TableCell>
		  <Link onClick={handleDeleteClick}>
			Delete
		  </Link>
		</TableCell>
		<ConfirmationPrompt
        open={isConfirmationOpen}
        onClose={handleCloseConfirmation}
        onConfirm={handleConfirmDelete}
        message={`Are you sure you want to delete user ${user.id}?`}
      />
	   {isFormOpen && (
        <UserForm user={user} onClose={handleCloseEditForm} onSave={handleSaveEditForm} isEdit={true}/>
      )}
	  </TableRow>
	);
  };

  export default UserTableRow;