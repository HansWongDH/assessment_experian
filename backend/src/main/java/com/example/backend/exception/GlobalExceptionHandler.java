package com.example.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler   {
	@ExceptionHandler({EmailTakenException.class})
	public ResponseEntity<Object> handleEmailTakenException(EmailTakenException exception)
	{
		return ResponseEntity.status(500).body(exception.getMessage());
	}
}
