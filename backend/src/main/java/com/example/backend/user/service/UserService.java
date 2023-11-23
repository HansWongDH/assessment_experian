package com.example.backend.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.EmailTakenException;
import com.example.backend.exception.UserIdNotFoundException;
import com.example.backend.user.UserRepository;
import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.validator.IValidator;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final IValidator<UserDto> userDtoValidator;

	@Autowired
	public UserService(UserRepository userRepository, IValidator<UserDto> userDtoValidator)
	{
		this.userRepository = userRepository;
		this.userDtoValidator = userDtoValidator;
	}

	public List<User> getAllUser(){
		return userRepository.findAll();
	}

	public void updateUser(Long id, UserDto userDto)
	{
		
		userDtoValidator.validate(userDto);
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if(!UserById.isPresent())
		{
			throw new UserIdNotFoundException(id);
		}
		User user = UserById.get();
		Optional<User> userByEmail = userRepository.findByEmailOptional(userDto.email);
		if (userByEmail.isPresent())
			throw new EmailTakenException(userDto.email);
		user.setEmail(userDto.email);
		user.setFirstName(userDto.firstName);
		user.setLastName(userDto.lastName);
		userRepository.save(user);
	}

	public void	createNewUser(User user){
		Optional<User> userByEmail = userRepository.findByEmailOptional(user.getEmail());
		if (userByEmail.isPresent())
			throw new EmailTakenException(user.getEmail());
		userRepository.save(user);
	}

	public void	deleteUser(Long id){
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if (!UserById.isPresent())
		{
			throw new UserIdNotFoundException(id);
		}
		userRepository.deleteById(id);
	}

}
