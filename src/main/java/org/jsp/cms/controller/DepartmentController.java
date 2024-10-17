package org.jsp.cms.controller;

import org.jsp.cms.entity.Department;
import org.jsp.cms.service.DepartmentService;
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
@RequestMapping ("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department){
		
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllDepartments(){
		
		return departmentService.findAllDepartments();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int id){
		
		return departmentService.findDepartmentById(id);
	}
	
	
	@PutMapping
	public ResponseEntity<?> updateDepartment(@RequestBody Department department){
		
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable int id){
		
		return departmentService.deleteDepartmentById(id);
		
	}
	
	
}
