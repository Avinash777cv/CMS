package org.jsp.cms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cms.dao.CourseDao;
import org.jsp.cms.entity.Course;
import org.jsp.cms.exceptionClasses.InvalidCredentialsException;
import org.jsp.cms.responseStructure.ResponseStructure;
import org.jsp.cms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Course Created Successfully...").body(courseDao.saveCourse(course)).build());
	}

	@Override
	public ResponseEntity<?> findAllCourses() {
		List<Course> courses = courseDao.findAllCourses();

		if (courses.isEmpty())
			throw InvalidCredentialsException.builder().message("No Course Found in the database table...").build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Courses Found successfully in the database table...").body(courses).build());
	}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
		Optional<Course> course = courseDao.findCourseById(id);

		if (course.isEmpty())
			throw InvalidCredentialsException.builder().message("No Course Id present in the database table... ")
					.build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message(" Course Found successfully in the database table...").body(course).build());
	}

	
	
	@Override
	public ResponseEntity<?> updateCourse(Course course) {
	
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Course Updated Successfully...").body(courseDao.updateCourse(course)).build());
		}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {

		Optional<Course> course = courseDao.findCourseById(id);

		if (course.isEmpty())
			throw InvalidCredentialsException.builder().message("No Course Id present to delete in the database table... ")
					.build();

		courseDao.deleteCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message(" Course Deleted successfully in the database table...").body(course.get()).build());
	}

}
