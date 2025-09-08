package com.capstone.project.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(JobNotFoundException.class)
	public ResponseEntity<ErrorResponce> handlingAccountNotFoundException(JobNotFoundException ex , HttpServletRequest request){
		ErrorResponce error = new ErrorResponce(
				  LocalDate.now(),
				  HttpStatus.NOT_FOUND.value(),
				  HttpStatus.NOT_FOUND.getReasonPhrase(),
				  ex.getMessage(),
				  request.getRequestURI()
				  );
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);	
	}
}
