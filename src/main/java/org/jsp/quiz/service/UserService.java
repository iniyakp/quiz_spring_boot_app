package org.jsp.quiz.service;

import org.jsp.quiz.dto.Userdto;
import org.jsp.quiz.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {


	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findUserByEmailAndPassword(Userdto userdto);

}
