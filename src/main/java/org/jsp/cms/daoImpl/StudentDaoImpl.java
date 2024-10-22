package org.jsp.cms.daoImpl;

import java.util.Optional;

import org.jsp.cms.dao.StudentDao;
import org.jsp.cms.entity.Student;
import org.jsp.cms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component

public class StudentDaoImpl implements StudentDao {

	
	@Autowired
	StudentRepository studentreRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentreRepository.save(student);
	}

	@Override
	public Optional<Student> findStudentById(int sid) {
		
		return studentreRepository.findById(sid);
	}
	
	

}
