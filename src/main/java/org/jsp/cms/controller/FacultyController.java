package org.jsp.cms.controller;

import java.util.Optional;

import org.jsp.cms.dao.UserDao;
import org.jsp.cms.entity.Department;
import org.jsp.cms.entity.Faculty;
import org.jsp.cms.entity.User;
import org.jsp.cms.exceptionClasses.InvalidCredentialsException;
import org.jsp.cms.repository.DepartmentRepository;
import org.jsp.cms.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyRepository fltrepository;
	@Autowired
	private UserDao dao;
	@Autowired
	private DepartmentRepository deprepository;
	
	
	@PostMapping("/{uid}")
	public Faculty saveFaculty(@RequestBody Faculty faculty,@PathVariable int uid) {
		
		Optional<User> optional=dao.findUserById(uid);
		
		if(optional.isEmpty())
			throw InvalidCredentialsException.builder().message("invalid user id ").build();
			User user=optional.get();
			faculty.setUser(user);
		    return fltrepository.save(faculty);
		
		    
	}
	
	@PatchMapping("/{fid}/{did}")
	public Faculty setDepartmentToFaculty(@PathVariable int fid,@PathVariable int did) {
		Optional<Faculty> optional1=fltrepository.findById(fid);
		Optional<Department> optional2=deprepository.findById(did);
		
		
		Faculty faculty=optional1.get();
		Department department=optional2.get();
		faculty.setDepartment(department);
		return fltrepository.save(faculty);
		
		
	}

}
