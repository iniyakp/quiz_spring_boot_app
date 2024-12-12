package org.jsp.quiz.dao;

import java.util.Optional;

import org.jsp.quiz.entity.User;

public interface UserDao {

	User saveUser(User user);

	Optional<User> findUserByEmailAndPassword(String email, String password);

}
