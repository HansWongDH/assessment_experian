package com.example.backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "api/v1/user")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUser() 
	{
		return userService.getAllUser();
	}

	@PostMapping
	public void	createUser(@RequestBody User user)
	{
		userService.createNewUser(user);
	}
}
