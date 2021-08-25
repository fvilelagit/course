package com.course.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	// Tipo da Excessão 
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource Not Found Exception - Id not found." + id ); // como isso aqui virou uma mensagem ? 
	}
	
}
