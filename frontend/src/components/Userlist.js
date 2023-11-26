import React, { useEffect, useState } from 'react';
import { getAllUsers } from '../libs/UsersApi/GetApi';
import UserTableRow from './UserTableRow';
import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TablePagination, TableRow } from '@mui/material';
import { useSnackbar } from 'notistack';

const UserList = () => {
    const [users, setUsers] = useState([]);
    const [page, setPage] = useState(0);
    const [refresh, setRefresh] = useState(false);
    const [rowsPerPage, setRowsPerPage] = useState(10);
    const { enqueueSnackbar } = useSnackbar();
    useEffect(() => {
        const fetchData = async () => {
            try {
              const response = await getAllUsers();
              setUsers(response.data);
              enqueueSnackbar("Successfully fetched all user data", {variant: 'success'});
            } catch (error) {
              console.error('Failed to fetch users:', error);
              enqueueSnackbar("Failed to fetch users data", {variant: 'error'});
            }
          };
        
        fetchData();
    }, [refresh, enqueueSnackbar]);
  
    const handleChangePage = (event, newPage) => {
      setPage(newPage);
    };
  
    const handleChangeRowsPerPage = (event) => {
      setRowsPerPage(parseInt(event.target.value, 10));
      setPage(0);
    };
  
    const handleRefresh = () => {
        setRefresh(!refresh)
    }

    const emptyRows = rowsPerPage - Math.min(rowsPerPage, users.length - page * rowsPerPage);
  
    return (
      <div>
        <h2>All User Entries</h2>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>ID</TableCell>
                <TableCell>Email</TableCell>
                <TableCell>First Name</TableCell>
                <TableCell>Last Name</TableCell>
                <TableCell>Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {(rowsPerPage > 0
                ? users.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                : users
              ).map((user) => (
                <UserTableRow user={user} refreshHandler={handleRefresh} />
              ))}
              {emptyRows > 0 && (
                <TableRow style={{ height: 53 * emptyRows }}>
                  <TableCell colSpan={5} />
                </TableRow>
              )}
            </TableBody>
          </Table>
        </TableContainer>
        <TablePagination
          rowsPerPageOptions={[10, 20, 50]}
          component="div"
          count={users.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </div>
    );
  };
  
  export default UserList;