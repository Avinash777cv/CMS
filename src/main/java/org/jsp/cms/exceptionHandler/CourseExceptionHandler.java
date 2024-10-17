package org.jsp.cms.exceptionHandler;

import org.jsp.cms.exceptionClasses.InvalidCredentialsException;
import org.jsp.cms.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandler {

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> InvalidCredentialsException(InvalidCredentialsException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder()
				.status(HttpStatus.NOT_FOUND.value()).message("No Course Found...").body(e.getMessage()).build());
	}

}
