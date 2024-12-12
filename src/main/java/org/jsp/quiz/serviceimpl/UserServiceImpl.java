package org.jsp.quiz.serviceimpl;

import java.util.Optional;

import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.dto.Userdto;
import org.jsp.quiz.entity.User;
import org.jsp.quiz.exceptionclasses.InvalidCredentialException;
import org.jsp.quiz.responsestructure.ResponseStructure;
import org.jsp.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("User Saved Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> findUserByEmailAndPassword(Userdto userdto) {
	Optional<User> optional=dao.findUserByEmailAndPassword(userdto.getEmail(),userdto.getPassword());
	if(optional.isEmpty()) 
		throw InvalidCredentialException.builder().message("Invalid Credential").build(); 
	
	 return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().httpStatus(HttpStatus.OK.value()).message("User Logined successfully..").body(optional.get()).build());
	  
	}

}
