package org.jsp.cms.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cms.dao.AdministratorDao;
import org.jsp.cms.entity.Administrator;
import org.jsp.cms.entity.Course;
import org.jsp.cms.exceptionClasses.InvalidCredentialsException;
import org.jsp.cms.responseStructure.ResponseStructure;
import org.jsp.cms.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService{

	@Autowired
	private AdministratorDao administratorDao;
	
	
	@Override
	public ResponseEntity<?> saveAdministrator(Administrator administrator) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Administrator Saved Successfully...").body(administratorDao.saveAdministrator(administrator)).build());
	}

	@Override
	public ResponseEntity<?> findAllAdministrators() {
		
		
		List<Administrator> administrators = administratorDao.findAllAdministrators();

		if (administrators.isEmpty())
			throw InvalidCredentialsException.builder().message("No Administrator Found in the database table...").build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Administrators Found successfully in the database table...").body(administrators).build());
	}

	@Override
	public ResponseEntity<?> findAdministratorById(int id) {
		
		Optional<Administrator> administrator = administratorDao.findAdministratorById(id);

		if (administrator.isEmpty())
			throw InvalidCredentialsException.builder().message("No Administrator Id present in the database table... ")
					.build();

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message(" Administrator Found successfully in the database table...").body(administrator).build());
	}

	@Override
	public ResponseEntity<?> updateAdministrator(Administrator administrator) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Administrator Updated Successfully...").body(administratorDao.updateAdministrator(administrator)).build());

	}

	@Override
	public ResponseEntity<?> deleteAdministratorById(int id) {

		Optional<Administrator> administrator = administratorDao.findAdministratorById(id);

		if (administrator.isEmpty())
			throw InvalidCredentialsException.builder().message("No Administrator Id present in the database table... ")
					.build();

		administratorDao.deleteAdministratorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message(" Administrator Deleted successfully in the database table...").body(administrator.get()).build());
	}

}
