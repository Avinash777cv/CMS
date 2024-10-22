package org.jsp.cms.dao;

import java.util.Optional;

import org.jsp.cms.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentDao {

	Student saveStudent(Student student);

	Optional<Student> findStudentById(int sid);

}
