package com.foodcourt.traceability.domain.exception.auth;

import com.foodcourt.traceability.domain.exception.BusinessException;

public class InvalidUserException extends BusinessException {
	public InvalidUserException(String message) {
		super(message);
	}
}
