package com.example.backend.user.dto;

public class UserUpdateDto {
	public Long id;
	public String firstName;
	public String lastName;
	public String email;

	public Boolean stringValidation(String input)
	{
		if (input.length() <= 0 || input == null)
			return false;
		return true;
	}

}
