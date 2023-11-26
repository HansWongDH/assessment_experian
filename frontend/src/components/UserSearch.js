import { Input } from "@mui/base";
import { getUserByEmail } from "../libs/UsersApi/GetApi"
import UserTableRow from "./UserTableRow"
import { Box, IconButton } from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import { useState } from "react";



const UserSearch = () => {
	const [email, setEmail] = useState('');
	const [user, setUser] = useState(null);
  
	const handleSearch = async () => {
		try {
		  const response = await getUserByEmail(email);
		  setUser(response.data);
		} catch (error) {
		  console.error('Error fetching user by email:', error);
		}
	  };
	return (
	  <Box>
		<Input
		  placeholder="Enter email"
		  value={email}
		  onChange={(e) => setEmail(e.target.value)}
		/>
		<IconButton onClick={handleSearch}>
		  <SearchIcon></SearchIcon>
		</IconButton>
  
		{user && <UserTableRow user={user} />}
	  </Box>
	);
  };
  
  export default UserSearch;