import { createUser } from "../libs/UsersApi/PostApi";
import UserForm from "./UserForm";


const UserCreation
 = ({CloseHandler}) => {

	const handleSaveEditForm = async (userDto) => {
	try
		{
			createUser(userDto);
		}
	catch (error){
		console.log('Error creating user', error);
		}
	  };
	
	  return (
		<UserForm user={null} onClose={CloseHandler} onSave={handleSaveEditForm} isEdit={false}/>)
}

export default UserCreation