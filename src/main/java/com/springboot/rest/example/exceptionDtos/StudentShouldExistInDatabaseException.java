package com.springboot.rest.example.exceptionDtos;

public class StudentShouldExistInDatabaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentShouldExistInDatabaseException(String message) {
		super(message);
	}
}
