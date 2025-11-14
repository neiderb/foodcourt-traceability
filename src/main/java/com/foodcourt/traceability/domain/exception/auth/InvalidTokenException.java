package com.foodcourt.traceability.domain.exception.auth;

import com.foodcourt.traceability.domain.exception.BusinessException;

public class InvalidTokenException extends BusinessException {
	public InvalidTokenException(String message) {
		super(message);
	}
}
