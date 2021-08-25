package com.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.course.service.exceptions.DataBaseException;
import com.course.service.exceptions.ResourceNotFoundException;
import com.sun.xml.bind.api.impl.NameConverter.Standard;

//Controller da excessão

@ControllerAdvice // Intercepta possíveis excessões pra esse objeto tratar.
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found :( ";
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = e.getMessage();
		
		StandardError e2 = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
		 
		return ResponseEntity.status(status).body(e2); // 
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request){
		String error = "Usuario em uso. :[ ";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String message = e.getMessage();
		
		StandardError e2 = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
		 
		return ResponseEntity.status(status).body(e2); // 
	}
	
	

}
