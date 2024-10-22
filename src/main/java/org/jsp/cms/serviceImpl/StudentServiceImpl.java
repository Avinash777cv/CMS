package org.jsp.cms.serviceImpl;

import java.util.Optional;

import org.jsp.cms.dao.DepartmentDao;
import org.jsp.cms.dao.StudentDao;
import org.jsp.cms.dao.UserDao;
import org.jsp.cms.entity.Department;
import org.jsp.cms.entity.Student;
import org.jsp.cms.entity.User;
import org.jsp.cms.responseStructure.ResponseStructure;
import org.jsp.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private DepartmentDao departmentdao;
	


	@Override
	public ResponseEntity<?> saveStudent(int uid, Student student) {
		
		
		Optional<User> optional1 = userdao.findUserById(uid);
		
		User user=optional1.get();
		
		student.setUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("student saved successfully...").body(studentdao.saveStudent(student)).build());
	}


	@Override
	public ResponseEntity<?> setDpartmentTOStudent(int sid, int did) {
		
		Optional<Department> optional1 = departmentdao.findDepartmentById(did);
		Optional<Student> optional2=studentdao.findStudentById(sid);                      
		Department department = optional1.get();
		 Student student = optional2.get();                     
		
		student.setDepartment(department);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("department seted to student").body(studentdao.saveStudent(student)).build());
	}

}
