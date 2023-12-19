package com.finalproject.hohoho.exceptions;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String message) {
        super(message);
    }
}
