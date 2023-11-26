package com.example.backend.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.EmailTakenException;
import com.example.backend.exception.EntryNotFoundException;
import com.example.backend.user.UserRepository;
import com.example.backend.user.dto.UserDto;
import com.example.backend.user.entity.User;
import com.example.backend.user.validator.IValidator;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final IValidator<User> userValidator;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, IValidator<User> userValidator)
	{
		this.userRepository = userRepository;
		this.userValidator = userValidator;
	}

	@Override
	public List<User> getAllUser(){
		return userRepository.findAll();
	}

	@Override
	public User getOneUserById(Long id){
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if(!UserById.isPresent())
		{
			throw new EntryNotFoundException(id);
		}
		return UserById.get();
	}

	@Override
	public User getOneUserByEmail(String email)
	{
		Optional<User> userByEmail = userRepository.findByEmailOptional(email);
		if (!userByEmail.isPresent())
		{
			throw new EntryNotFoundException(email);
		}

		return userByEmail.get();
	}

	@Override
	public void updateUser(Long id, UserDto userDto)
	{
		
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if(!UserById.isPresent())
		{
			throw new EntryNotFoundException(id);
		}
		User user = UserById.get();;
		Optional<User> userByEmail = userRepository.findByEmailOptional(userDto.email);
		if (userByEmail.isPresent() && !user.getEmail().equals(userDto.email))
			throw new EmailTakenException(userDto.email);
		user.setEmail(userDto.email);
		user.setFirstName(userDto.firstName);
		user.setLastName(userDto.lastName);
		userValidator.validate(user);
		userRepository.save(user);
	}

	@Override
	public void	createNewUser(UserDto userDto){
		Optional<User> userByEmail = userRepository.findByEmailOptional(userDto.email);
		if (userByEmail.isPresent())
			throw new EmailTakenException(userDto.email);
		User user = new User(userDto.firstName, userDto.lastName, userDto.email);
		userValidator.validate(user);
		userRepository.save(user);
	}

	@Override
	public void	deleteUser(Long id){
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if (!UserById.isPresent())
		{
			throw new EntryNotFoundException(id);
		}
		userRepository.deleteById(id);
	}

}
