package org.jsp.cms.daoImpl;

import org.jsp.cms.dao.EnrollmentDao;
import org.jsp.cms.entity.Enrollment;
import org.jsp.cms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EnrollmentDaoImpl implements EnrollmentDao {

	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	
	@Override
	public Enrollment saveEnrollment(Enrollment enrollment) {
		
		return enrollmentRepository.save(enrollment);
	}

}
