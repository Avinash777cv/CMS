package org.jsp.cms.service;

import org.jsp.cms.entity.User;
import org.jsp.cms.util.AuthUser;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<?> login(AuthUser authUser);

	ResponseEntity<?> updateUser(User user);

	ResponseEntity<?> deleteUserById(int id);

	
	
}
