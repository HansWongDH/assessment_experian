package com.example.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler   {
	@ExceptionHandler({HttpMessageNotReadableException.class})
	public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

	@ExceptionHandler({EmailTakenException.class})
	public ResponseEntity<Object> handleEmailTakenException(EmailTakenException exception)
	{
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler({UserIdNotFoundException.class})
	public ResponseEntity<Object> handleUserIdNotFoundException(UserIdNotFoundException exception)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler({ValidationException.class})
	public ResponseEntity<Object> handleValidationException(ValidationException exception)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}
}
