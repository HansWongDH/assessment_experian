package com.example.backend.user.validator;

import com.example.backend.exception.ValidationException;

public interface IValidator<T> {
	void validate(T entity) throws ValidationException;
}