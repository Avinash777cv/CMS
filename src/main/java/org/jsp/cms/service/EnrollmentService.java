package org.jsp.cms.service;

import org.jsp.cms.entity.Enrollment;
import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

	ResponseEntity<?> saveEnrollment(Enrollment enrollment, int cid, int sid);

}
