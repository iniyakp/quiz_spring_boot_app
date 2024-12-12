package org.jsp.quiz.exceptionclasses;

import lombok.Builder;

@Builder
public class InvalidCredentialException extends RuntimeException {

	private String message;

	public InvalidCredentialException(String message) {
		this.message = message;
	}

	public InvalidCredentialException() {

	}

	@Override
	public String getMessage() {
		return this.getMessage();
	}

}
