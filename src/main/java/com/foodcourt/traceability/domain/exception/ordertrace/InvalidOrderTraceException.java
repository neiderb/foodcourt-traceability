package com.foodcourt.traceability.domain.exception.ordertrace;

public class InvalidOrderTraceException extends RuntimeException {
	public InvalidOrderTraceException(String message) {
		super(message);
	}
}
