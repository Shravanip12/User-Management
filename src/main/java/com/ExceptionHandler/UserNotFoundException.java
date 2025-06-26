package com.ExceptionHandler;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException {

//	private String msg;
	public UserNotFoundException(String msg)
	{
		
		super(msg);
	}
}
