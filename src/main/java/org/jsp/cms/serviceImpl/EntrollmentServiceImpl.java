package org.jsp.cms.serviceImpl;

import java.util.Optional;

import org.jsp.cms.dao.CourseDao;
import org.jsp.cms.dao.EnrollmentDao;
import org.jsp.cms.dao.StudentDao;
import org.jsp.cms.entity.Course;
import org.jsp.cms.entity.Enrollment;
import org.jsp.cms.entity.Student;
import org.jsp.cms.responseStructure.ResponseStructure;
import org.jsp.cms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class EntrollmentServiceImpl implements EnrollmentService {
	
	@Autowired
	EnrollmentDao enrollmentdao;
	@Autowired
	StudentDao studentdao;
	@Autowired
	CourseDao coursedao;

	@Override
	public ResponseEntity<?> saveEnrollment(Enrollment enrollment, int cid, int sid) {
		Optional<Student> op1 = studentdao.findStudentById(sid);
		Optional<Course> op2 = coursedao.findCourseById(cid);
		
		Student student = op1.get();
		Course course=op2.get();
		
		enrollment.setStudent(student);
		enrollment.setCourse(course);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Entrollment saved successfully..").body(enrollmentdao.saveEnrollment(enrollment)).build());
	}

}
