import { Button, Dialog, DialogActions, DialogContent, DialogTitle, TextField } from "@mui/material";
import { useEffect, useState } from "react";


const UserForm = ({ user, onClose, onSave, isEdit }) => {
	const [formData, setFormData] = useState({
	  id: '',
	  email: '',
	  firstName: '',
	  lastName: '',
	});
  
	useEffect(() => {
	  // If in edit mode, populate the form with existing user data
	  if (isEdit && user) {
		setFormData({
		  id: user.id,
		  email: user.email,
		  firstName: user.firstName,
		  lastName: user.lastName,
		});
	  }
	}, [user, isEdit]);
  
	const handleChange = (e) => {
	  const { name, value } = e.target;
	  setFormData((prevData) => ({ ...prevData, [name]: value }));
	};

	const validateForm = () => {

		let valid = true;
		if (!/^\S+@\S+\.\S+$/.test(formData.email)) {
		  valid = false;
		}
	
		['firstName', 'lastName'].forEach((field) => {
		  if (formData[field].trim() === '' || formData[field].length > 25) {
			valid = false;
		  }
		});
	
		return valid;
	  };
  
	const handleSave = () => {
	if (validateForm())
	{
		onSave(formData);
	}
	else
	{
		console.log("error invalid form");
	}

	  onClose();
	};
  
	return (
	  <Dialog open={true} onClose={onClose}>
		<DialogTitle>{isEdit ? 'Edit User' : 'Add User'}</DialogTitle>
		<DialogContent>
		  <TextField
			label="Email"
			name="email"
			value={formData.email}
			onChange={handleChange}
			fullWidth
			margin="normal"
		  />
		  <TextField
			label="First Name"
			name="firstName"
			value={formData.firstName}
			onChange={handleChange}
			fullWidth
			margin="normal"
		  />
		  <TextField
			label="Last Name"
			name="lastName"
			value={formData.lastName}
			onChange={handleChange}
			fullWidth
			margin="normal"
		  />
		</DialogContent>
		<DialogActions>
		  <Button onClick={onClose} color="primary">
			Cancel
		  </Button>
		  <Button onClick={handleSave} color="primary">
			{isEdit ? 'Save' : 'Add'}
		  </Button>
		</DialogActions>
	  </Dialog>
	);
  };
  
  export default UserForm;