package org.jsp.cms.controller;

import java.util.Optional;

import org.jsp.cms.dao.DepartmentDao;
import org.jsp.cms.entity.Course;
import org.jsp.cms.entity.Department;
import org.jsp.cms.entity.Faculty;
import org.jsp.cms.repository.CourseRepository;
import org.jsp.cms.repository.DepartmentRepository;
import org.jsp.cms.repository.FacultyRepository;
import org.jsp.cms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	@Autowired
	private FacultyRepository fltrepository;
	@Autowired
	private CourseRepository currepository;
	@Autowired
	private DepartmentRepository deptrepository;
	
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
	
	@PatchMapping("/faculty/{cid}/{fid}")
	public Course setFacultyToCourse(@PathVariable int cid,@PathVariable int fid) {
		
		Optional<Faculty> optional1=fltrepository.findById(fid);
		
		Optional<Course> optional2=currepository.findById(cid);
		
		Faculty faculty = optional1.get();
		Course coures = optional2.get();
		
		coures.setFaculty(faculty);
		
		
		
		return currepository.save(coures);
	}
	@PatchMapping("/department/{cid}/{did}")
	public Course setDepartmentToCourse(@PathVariable int cid,@PathVariable int did) {
		
	  Optional<Department> optional1 = deptrepository.findById(did);
		
		Optional<Course> optional2=currepository.findById(cid);
		
	    Department department = optional1.get();
		Course coures = optional2.get();
		
		coures.setDepartment(department);
		
		return currepository.save(coures);
	}
	
	
}
