package com.prathamesh.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prathamesh.exception.EmployeeNotFoundException;
import com.prathamesh.model.ErrorData;

@RestControllerAdvice
public class CustomExceptionHandlerService {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorData> handleEmployeeNotFoundException(EmployeeNotFoundException enfe){
		ResponseEntity<ErrorData> responseEntity = new ResponseEntity<ErrorData>(new ErrorData(enfe.getMessage(), new Date().toString(),"Employee"),HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}
