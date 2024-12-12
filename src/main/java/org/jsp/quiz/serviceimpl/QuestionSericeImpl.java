package org.jsp.quiz.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.QuestionDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.TakeQuiz;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.exceptionclasses.InvalidQuestionIdException;
import org.jsp.quiz.exceptionclasses.NoQuestionFoundException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

 // error lack of system properties error will come   .

@Service
public class QuestionSericeImpl implements QuestionService {
	@Autowired
	private QuestionDao dao;

	@Override
	public ResponseEntity<?> saveQuestion(Question question) { // this question is coming from client and it don't have id also 
	question=dao.saveQuestion(question);
//	ResponseStructure<Question> structure=new ResponseStructure<>();
//     structure.setHttpStatus(HttpStatus.OK.value());
//     structure.setMessage("Question Saved Successfully....");
//     structure.setBody(question);
//		return new ResponseEntity<>(structure,HttpStatus.OK);
	
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question Saved Successfully...").body(question).build());
	}

	@Override
	public ResponseEntity<?> findAllQuestions() {
	 // List<Question> questions=	dao.findAllQuestions();
		
		
		 List<Question> questions=	dao.findAllActiveQuestions();
		 
		 List<QuestionDto> dtolist=new ArrayList<>();
		 for(Question q: questions) 
			 dtolist.add(new QuestionDto(q.getTitle(),q.getA(),q.getB(),q.getB(),q.getC()));
		
	  if(dtolist.isEmpty()) 
		  
		  throw NoQuestionFoundException.builder().message("No Questions found in the database....").build();
	  
	      return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("All Questions Founded..").body(dtolist).build());
	  
	
	}

	@Override
	public ResponseEntity<?> findQuestionsById(int id) {
	Optional<Question> optional=dao.findQuestionsById(id);
	if(optional.isEmpty()) 
		throw InvalidQuestionIdException.builder().message("Invalid Question ID").build();
	
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Question found successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses) {
		int c=0;
		for(QuizResponse qr:quizResponses) {
		Optional<Question> q=dao.findQuestionsById(qr.getId());
		
//		if(q.isEmpty()) {
//			throw InvalidQuestionIdException.builder().message("Invalid Question Id unable to delete..").build();
//		}
		
		Question question=q.get();
		if(question.getAns().equalsIgnoreCase(qr.getAns())) {
			c++;
		}
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("Submission Successfull").body("Your score : "+c).build());
	}


//	@Override
//	public ResponseEntity<?> takeQuiz() {
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<?> takeQuiz(List<TakeQuiz> takeQuiz) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	




	

	



}
