package org.jsp.cms.service;

import org.jsp.cms.entity.Student;
import org.jsp.cms.serviceImpl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	ResponseEntity<?> saveStudent(int uid, Student student);

	ResponseEntity<?> setDpartmentTOStudent(int sid, int did);

}
