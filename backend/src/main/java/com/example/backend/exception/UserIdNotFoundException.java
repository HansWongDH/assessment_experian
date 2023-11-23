package com.example.backend.exception;

public class UserIdNotFoundException extends RuntimeException {
	public UserIdNotFoundException(Long id)
	{
		/*super: calling the immediate parent constructor, in this case, 
		RuntimeException Constructor to construct with the custon message*/
		super("UserId:" + id +  "not found");
	}
}
