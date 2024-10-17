package org.jsp.cms.service;

import org.jsp.cms.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findAllCourses();

	ResponseEntity<?> findCourseById(int id);

	ResponseEntity<?> updateCourse(Course course);

	ResponseEntity<?> deleteCourseById(int id);

}
