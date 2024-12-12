package org.jsp.quiz.daoImpl;

import java.util.Optional;

import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl  implements UserDao{
	@Autowired
	private UserRepository repo;

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

	@Override
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email,password);
	}
}
