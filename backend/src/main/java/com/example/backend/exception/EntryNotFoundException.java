package com.example.backend.exception;

public class EntryNotFoundException extends RuntimeException {
	public EntryNotFoundException(Long id)
	{
		super("UserId: " + id +  " not found");
	}

	public EntryNotFoundException(String email)
	{
		super("Email: '" + email + "' not found");
	}
}
