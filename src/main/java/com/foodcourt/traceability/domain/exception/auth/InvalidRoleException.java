package com.foodcourt.traceability.domain.exception.auth;

import com.foodcourt.traceability.domain.exception.BusinessException;

public class InvalidRoleException extends BusinessException {
	public InvalidRoleException(String message) {
		super(message);
	}
}
