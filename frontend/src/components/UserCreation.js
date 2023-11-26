import {  useSnackbar } from 'notistack';
import { createUser } from "../libs/UsersApi/PostApi";
import UserForm from "./UserForm";


const UserCreation = ({ CloseHandler }) => {
	const { enqueueSnackbar } = useSnackbar();
  
	const handleSaveEditForm = async (userDto) => {
	  try {
		await createUser(userDto);
		enqueueSnackbar('User created successfully', { variant: 'success' });
	  } catch (error) {
		console.error('Error creating user', error);
		enqueueSnackbar('Failed to create new user', { variant: 'error' });
	  }
	};
  
	return <UserForm user={null} onClose={CloseHandler} onSave={handleSaveEditForm} isEdit={false} />;
  };
  
  export default UserCreation;