package org.jsp.quiz.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.TakeQuiz;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	private QuestionRepository repo;

	@Override
	public Question saveQuestion(Question question) {
		return repo.save(question);
	}

	@Override
	public List<Question> findAllQuestions() {
		return repo.findAll();
	}

	@Override
	public Optional<Question> findQuestionsById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Question> findAllActiveQuestions() {
		return repo.findAllActiveQuestions();
	}

//	@Override
//	public List<Question> takeQuiz(){
//		return repo.findRandomQuestions(PageRequest.of(0, 5));
//	}

}
