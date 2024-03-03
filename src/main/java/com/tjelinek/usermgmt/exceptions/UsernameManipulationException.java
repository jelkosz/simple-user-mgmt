package com.tjelinek.usermgmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UsernameManipulationException extends RuntimeException {

	private static final long serialVersionUID = -4568277615470348022L;

	public UsernameManipulationException(String message) {
		super(message);
	}
}
