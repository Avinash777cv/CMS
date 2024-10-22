package org.jsp.cms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cms.dao.UserDao;
import org.jsp.cms.entity.User;
import org.jsp.cms.exceptionClasses.InvalidCredentialsException;
import org.jsp.cms.responseStructure.ResponseStructure;
import org.jsp.cms.service.UserService;
import org.jsp.cms.util.AuthUser;
import org.jsp.cms.util.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public ResponseEntity<?> saveUser(User user) {
		
		user.setStatus(UserStatus.IN_ACTIVE);
		
		user=userDao.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User saved successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
	List<User> users = userDao.findAllUsers();
	
	if(users.isEmpty())
		throw  InvalidCredentialsException.builder().message("No User present in the database table...").build();
	
	
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("All Users found successfully...").body(users).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> user = userDao.findUserById(id);
		
		if(user.isEmpty())
			throw  InvalidCredentialsException.builder().message("No User Id present in the database table...").build();
		
		
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User found successfully... in the database table...").body(user.get()).build());
	}


	@Override
	public ResponseEntity<?> updateUser(User user) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Student Updated Successfully...").body(userDao.updateUser(user)).build());
	}

	@Override
	public ResponseEntity<?> deleteUserById(int id) {
		Optional<User> user = userDao.findUserById(id);
		if(user.isEmpty())
			throw InvalidCredentialsException.builder().message("No User Id present in the database table to delete...").build();
		userDao.deleteUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Deleted Successfully...").body(user.get()).build());
	}
	
	
	
	
	@Override
	public ResponseEntity<?> login(AuthUser authUser) {
		
		
		
		Optional<User> optional = userDao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());
		
		if(optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invalid Username or Password").build();
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User verified successfully...").body(optional.get()).build());
	}

}
