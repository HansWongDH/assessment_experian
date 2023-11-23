package com.example.backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	List<User> getAllUser(){
		return userRepository.findAll();
	}

	void	createNewUser(User user){
		userRepository.save(user);
	}
}
