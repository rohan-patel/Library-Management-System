package com.rohan.lms.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rohan.lms.model.Error;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	private Error handleEntityNotFound(EntityNotFoundException ex) {
		return new Error(HttpStatus.NOT_FOUND, "Entity not found", ex.getMessage());
	}

	
	@ExceptionHandler(EntityAlreadyExistsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	private Error handleEntityAlreadyExists(EntityAlreadyExistsException ex) {
		return new Error(HttpStatus.BAD_REQUEST, "Entity Already Exists", ex.getMessage());
	}
	
	@ExceptionHandler(InsufficientDataException.class)
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	private Error handleInsufficientData(InsufficientDataException ex) {
		return new Error(HttpStatus.NOT_ACCEPTABLE, "Data provided in payload is not sufficient", ex.getMessage());
	}
	
	

}
