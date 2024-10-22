package org.jsp.cms.controller;

import org.jsp.cms.entity.Enrollment;
import org.jsp.cms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
	
	@Autowired
	EnrollmentService enrollmentService;
	
	
	@PostMapping("/{cid}/{sid}")
	public ResponseEntity<?> saveEnrollment(@RequestBody Enrollment enrollment,@PathVariable int cid,@PathVariable int sid){
		
		return enrollmentService.saveEnrollment(enrollment ,cid,sid);
				
	}
	

}
