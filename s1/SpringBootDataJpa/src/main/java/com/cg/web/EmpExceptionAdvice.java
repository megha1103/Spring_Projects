package com.cg.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.exceptions.EmpIdException;
import com.cg.exceptions.EmpNotFoundException;

//@ControllerAdvice
@RestControllerAdvice
public class EmpExceptionAdvice {

	@ExceptionHandler(value = { EmpIdException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Id already exists")
	public void handleException(Exception ex) {

	}

	@ExceptionHandler(value = { EmpNotFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee Not found")
	//@ResponseBody
	public void handleException2(Exception ex) {

	}
	
	
	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	//@ResponseBody
	public ErrorInfo handleException3(Exception ex) {
		System.out.println(ex.getMessage());
       if(ex.getMessage().contains("doj"))
    	   return new ErrorInfo("Date must have the patten yyyy-M-d");
       return new ErrorInfo(ex.getMessage());
	}
}
