package com.example.backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.user.dto.UserUpdateDto;

@RestController
@RequestMapping(path= "api/v1/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	/**
	 * find all user exist in database and return it
	 * @return
	 */
	@GetMapping
	public List<User> getAllUser() 
	{
		return userService.getAllUser();
	}


	@PutMapping(path = "{UserId}")
	public void	updateUser(@PathVariable("UserId") long id,
	 @RequestBody() UserUpdateDto userUpdateDto)
	{
		userService.updateUser(id, userUpdateDto);
	}

	@PostMapping
	public void	createUser(@RequestBody User user)
	{
		userService.createNewUser(user);
	}
	
	/**
	 * delete user that matches the id
	 * eg: api/v1/user/2 will delete user with id 2
	 */
	@DeleteMapping(path = "{UserId}")
	public void deleteUser(@PathVariable("UserId") Long id)
	{
		userService.deleteUser(id);
	}

}
