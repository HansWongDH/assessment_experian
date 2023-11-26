package com.example.backend.user.service;

import java.util.List;

import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;

public interface UserService {

	List<User> getAllUser();
	User getOneUserById(Long id);
	User getOneUserByEmail(String email);
    void updateUser(Long id, UserDto userDto);
    void createNewUser(UserDto userDto);
    void deleteUser(Long id);

}
