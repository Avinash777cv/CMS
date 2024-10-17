package org.jsp.cms.controller;

import org.jsp.cms.entity.User;
import org.jsp.cms.service.UserService;
import org.jsp.cms.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value =  "/users")
public class UserController {

	@Autowired
	private  UserService userService;
	
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		
		return userService.saveUser(user);
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		
		return userService.findAllUsers();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id){
		
		return userService.findUserById(id);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user){
		
		return userService.updateUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id){
		
		return userService.deleteUserById(id);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthUser authUser){
		
		return userService.login(authUser);
	}
	
}
