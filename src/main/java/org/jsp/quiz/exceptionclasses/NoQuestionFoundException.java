package org.jsp.quiz.exceptionclasses;

import lombok.Builder;

@Builder // without using new keyword we can create a object.
public class NoQuestionFoundException extends RuntimeException {
	
	private String message;

	public NoQuestionFoundException(String message) {

		this.message = message;
	}

	public NoQuestionFoundException() {

	}

	@Override
	public String getMessage() {
		return this.getMessage();
	}

}
