package com.ExceptionHandler;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GobalExceptionHandler {
	final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?>handleNullPointerException(Exception e){
		log.error("message:"+e.getMessage());
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException u){
		return new ResponseEntity(u.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
