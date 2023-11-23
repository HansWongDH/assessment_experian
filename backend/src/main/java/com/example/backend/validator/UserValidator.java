package com.example.backend.validator;

import java.util.Objects;

import com.example.backend.exception.ValidationException;
import com.example.backend.user.entity.User;

public class UserValidator implements IValidator<User> {
	@Override
	public void	validate(User user) throws ValidationException{
		if (Objects.isNull(user.getID()) || user.getID() < 0)
			throw new ValidationException("User Id cannot be " + (user.getID() < 0 ? "negative" : "null"));
		if (validateString(user.getFirstName())) {
			throw new ValidationException("First name is empty");
		}
		if (validateString(user.getLastName())) {
			throw new ValidationException("Last name is empty");
		}
		if (validateString(user.getEmail())) {
			throw new ValidationException("Email is empty");
		}
	}

	private boolean validateString(String input){
		if (input == null || input.isEmpty())
			return false;
		return true;
	}
}
