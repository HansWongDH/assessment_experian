import { Button, Container, Drawer, Grid, Typography } from "@mui/material";
import { useState } from "react";
import UserCreation from "./UserCreation";
import UserList from "./Userlist";
import UserSearch from "./UserSearch";
const FrontPage = () => {
	const [isUserListOpen, setUserListOpen] = useState(false);
	const [isUserFormOpen, setUserFormOpen] = useState(false);
	const [isSearchUserOpen, setSearchUserOpen] = useState(false);
  
	const handleFindAllUsers = () => {
	  setUserListOpen(true);
	};
  
	const handleCreateNewUser = () => {
	  setUserFormOpen(true);
	};
  
	const handleFindUserByEmail = () => {
	  setSearchUserOpen(true);
	};
  
	const handleCloseDrawer = () => {
	  setUserListOpen(false);
	  setUserFormOpen(false);
	  setSearchUserOpen(false);
	};
  
	return (
		<Container style={{ display: 'flex', flexDirection: 'column', height: '100vh' }}>
		<Typography variant="h2" gutterBottom>
		  Welcome to User Management System
		</Typography>
		<Grid container spacing={2}>
		  <Grid item>
			<Button variant="contained" onClick={handleFindAllUsers}>
			  Find All User Entries
			</Button>
		  </Grid>
		  <Grid item>
			<Button variant="contained" onClick={handleCreateNewUser}>
			  Create New User
			</Button>
		  </Grid>
		  <Grid item>
			<Button variant="contained" onClick={handleFindUserByEmail}>
			  Find User by Email
			</Button>
		  </Grid>
		</Grid>
  
		<Drawer anchor="bottom" open={isUserListOpen} onClose={handleCloseDrawer}>
		  <UserList/>
		</Drawer>
  
		<Drawer anchor="bottom" open={isUserFormOpen} onClose={handleCloseDrawer}>
		  <UserCreation CloseHandler={handleCloseDrawer}></UserCreation>
		</Drawer>
  
		<Drawer
		anchor="top" open={isSearchUserOpen} onClose={handleCloseDrawer}>
			<UserSearch></UserSearch>
		</Drawer>
	  </Container>
	);
  };
  
  export default FrontPage;