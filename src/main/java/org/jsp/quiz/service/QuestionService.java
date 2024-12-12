package org.jsp.quiz.service;

import java.util.List;

import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.dto.TakeQuiz;
import org.jsp.quiz.entity.Question;
import org.springframework.http.ResponseEntity;

public interface QuestionService {

	ResponseEntity<?> saveQuestion(Question question);

	ResponseEntity<?> findAllQuestions();

	ResponseEntity<?> findQuestionsById(int id);

	ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses);

//	ResponseEntity<?> takeQuiz(List<TakeQuiz> takeQuiz);

//	ResponseEntity<?> takeQuiz();



}
