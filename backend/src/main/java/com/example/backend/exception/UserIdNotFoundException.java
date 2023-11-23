package com.example.backend.exception;

public class UserIdNotFoundException extends RuntimeException {
	public UserIdNotFoundException(Long id)
	{
		super("UserId:" + id +  "not found");
	}
}
