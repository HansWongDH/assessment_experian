package com.example.backend.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.service.UserService;

@SpringBootTest
class	UserControllerTest {

	//create mock instances
	@Mock
    private UserService userService;

	//inject mocks instances
    @InjectMocks
    private UserController userController;

    @Test
    void testGetUserByEmail() {
        String email = "test@gmail.com";
        User expectedUser = new User("test", "test", "test@gmail.com");
        when(userService.getOneUserByEmail(email)).thenReturn(expectedUser);

        User result = userController.getUserbyId(email);

        assertEquals(expectedUser, result);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User expectedUser = new User("test", "test", "test@gmail.com");
        when(userService.getOneUserById(userId)).thenReturn(expectedUser);

        User result = userController.getUserbyId(userId);

        assertEquals(expectedUser, result);
    }

    @Test
    void testGetAllUser() {
        java.util.List<User> expectedUsers = Arrays.asList(
			new User("test", "test", "test@gmail.com"),
			new User("test2", "test2", "test2@gmail.com")
		);

        when(userService.getAllUser()).thenReturn(expectedUsers);

        java.util.List<User> result = userController.getAllUser();

        assertEquals(expectedUsers, result);
    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        UserDto userDto = new UserDto(null, "test", "test", "test");

        userController.updateUser(userId, userDto);

        verify(userService).updateUser(eq(userId), eq(userDto));
    }

    @Test
    void testCreateUser() {
        User user = new User("test", "test", "test@gmail.com");


        userController.createUser(user);

        verify(userService).createNewUser(eq(user));
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;

        userController.deleteUser(userId);

        verify(userService).deleteUser(eq(userId));
    }
}