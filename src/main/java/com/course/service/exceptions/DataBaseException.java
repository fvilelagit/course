package com.course.service.exceptions;

public class DataBaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataBaseException(Object id) {
		super("Usuário em uso ");
	}
	
}
