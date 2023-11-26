import {
	Dialog,
	DialogActions,
	DialogContent,
	DialogContentText,
	DialogTitle,
	Button,
  } from '@mui/material';
  
  const ConfirmationPrompt = ({ open, onClose, onConfirm, message }) => {
	return (
	  <Dialog open={open} onClose={onClose}>
		<DialogTitle>Confirmation</DialogTitle>
		<DialogContent>
		  <DialogContentText>{message}</DialogContentText>
		</DialogContent>
		<DialogActions>
		  <Button onClick={onClose} color="primary">
			Cancel
		  </Button>
		  <Button onClick={onConfirm} color="primary" autoFocus>
			Confirm
		  </Button>
		</DialogActions>
	  </Dialog>
	);
  };
  
  export default ConfirmationPrompt