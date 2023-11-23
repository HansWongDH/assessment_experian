package com.example.backend.exception;

public class EmailTakenException extends RuntimeException{
	public EmailTakenException(String email)
	{
		/*super: calling the immediate parent constructor, in this case, 
		RuntimeException Constructor to construct with the custon message*/
		super("Email '" + email + "' is already taken");
	}
}
