package org.jsp.quiz.exceptionHandlerClass;

import org.jsp.quiz.exceptionclasses.InvalidCredentialException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandlerClass {
	
	@ResponseBody
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<?> invalidCredentialException(InvalidCredentialException e){
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("Invalid Credential....").body(e.getMessage()).build());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("Invalid Credential....").body(e.getMessage()).build());
	
	}

}
