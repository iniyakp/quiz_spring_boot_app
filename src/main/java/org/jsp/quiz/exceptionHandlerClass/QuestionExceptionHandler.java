package org.jsp.quiz.exceptionHandlerClass;

import org.jsp.quiz.exceptionclasses.InvalidQuestionIdException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	
	@ExceptionHandler(InvalidQuestionIdException.class)
	public ResponseEntity<?> invalidQuestionIdException(InvalidQuestionIdException e){
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("Questions Not found").body(e.getMessage()).build());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Q hi");
	}

}
