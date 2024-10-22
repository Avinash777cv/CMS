package org.jsp.cms.controller;

import org.jsp.cms.entity.Student;
import org.jsp.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/{uid}")
	public ResponseEntity<?> saveStudent(@PathVariable int uid,@RequestBody Student student){
		
		return studentService.saveStudent(uid,student);
	}
	
	@PatchMapping("/department/{sid}/{did}")
	public ResponseEntity<?> setDepartmentToStudent(@PathVariable int sid,@PathVariable int did){
		
		return studentService.setDpartmentTOStudent(sid,did);
	}
	

}
