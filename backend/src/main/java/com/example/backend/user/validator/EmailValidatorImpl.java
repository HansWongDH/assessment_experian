package com.example.backend.user.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class EmailValidatorImpl implements EmailValidator {
	private final Pattern pattern = 
		Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	@Override
	public boolean validateEmail(String email)
	{
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
