package com.example.backend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.EmailTakenException;
import com.example.backend.exception.UserIdNotFoundException;
import com.example.backend.user.dto.UserUpdateDto;

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

	void updateUser(Long id, UserUpdateDto userUpdateDto)
	{
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if(!UserById.isPresent())
		{
			throw new UserIdNotFoundException(id);
		}
		User user = UserById.get();
		if (userUpdateDto.stringValidation(userUpdateDto.email))
			user.setEmail(userUpdateDto.email);
		if (userUpdateDto.stringValidation(userUpdateDto.firstName))
			user.setFirstName(userUpdateDto.firstName);
		if (userUpdateDto.stringValidation(userUpdateDto.lastName))
			user.setLastName(userUpdateDto.lastName);
		userRepository.save(user);
	}

	void	createNewUser(User user){
		Optional<User> userByEmail = userRepository.findByEmailOptional(user.getEmail());
		if (userByEmail.isPresent())
			throw new EmailTakenException(user.getEmail());
		userRepository.save(user);
	}

	void	deleteUser(Long id){
		Optional<User> UserById = userRepository.findByIDOptional(id);
		if (!UserById.isPresent())
		{
			throw new UserIdNotFoundException(id);
		}
		userRepository.deleteById(id);
	}

}
