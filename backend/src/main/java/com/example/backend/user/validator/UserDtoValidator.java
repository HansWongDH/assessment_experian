package com.example.backend.user.validator;


import org.springframework.stereotype.Component;

import com.example.backend.exception.ValidationException;
import com.example.backend.user.dto.UserDto;

@Component
public class UserDtoValidator implements IValidator<UserDto>{
	private final EmailValidator emailValidator;

	UserDtoValidator(EmailValidator emailValidator){
		this.emailValidator = emailValidator;
	}

	@Override
	public void	validate(UserDto userDto) throws ValidationException{
		if (!validateString(userDto.firstName)) {
			throw new ValidationException("First name is empty");
		}
		if (!validateString(userDto.lastName)) {
			throw new ValidationException("Last name is empty");
		}
		if (!validateString(userDto.email)) {
			throw new ValidationException("Email is empty");
		}
		if (!emailValidator.validateEmail(userDto.email)){
			throw new ValidationException("Invalid email format");
		}
	}

	private boolean validateString(String input){
		if (input == null || input.isEmpty())
			return false;
		return true;
	}
}
