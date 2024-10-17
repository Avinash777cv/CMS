package org.jsp.cms.controller;

import org.jsp.cms.entity.Administrator;
import org.jsp.cms.entity.Course;
import org.jsp.cms.service.AdministratorService;
import org.jsp.cms.service.CourseService;
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
@RequestMapping("/administrators")
public class AdministratorController {


	@Autowired
	private AdministratorService administratorService;
	
	@PostMapping
	public ResponseEntity<?> saveAdministrator(@RequestBody Administrator administrator){
		
		return administratorService.saveAdministrator(administrator);
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAllAdministrators(){
		return administratorService.findAllAdministrators();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAdministratorById(@PathVariable int id){
		return administratorService.findAdministratorById(id);
	}
	
	@PutMapping
	public ResponseEntity<?> updateAdministrator(@RequestBody Administrator administrator){
		
		return administratorService.updateAdministrator(administrator);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAdministratorById(@PathVariable int id){
		return administratorService.deleteAdministratorById(id);
	}
}


