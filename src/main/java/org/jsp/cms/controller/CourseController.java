package org.jsp.cms.controller;

import org.jsp.cms.entity.Course;
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
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course){
		
		return courseService.saveCourse(course);
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAllCourses(){
		return courseService.findAllCourses();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCourseById(@PathVariable int id){
		return courseService.findCourseById(id);
	}
	
	@PutMapping
	public ResponseEntity<?> updateCourse(@RequestBody Course course){
		
		return courseService.updateCourse(course);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable int id){
		return courseService.deleteCourseById(id);
	}
}
