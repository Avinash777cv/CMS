package org.jsp.cms.service;

import org.jsp.cms.entity.Administrator;
import org.springframework.http.ResponseEntity;

public interface AdministratorService {

	ResponseEntity<?> saveAdministrator(Administrator administrator);

	ResponseEntity<?> findAllAdministrators();

	ResponseEntity<?> findAdministratorById(int id);

	ResponseEntity<?> updateAdministrator(Administrator administrator);

	ResponseEntity<?> deleteAdministratorById(int id);

	
}
