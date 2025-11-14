package com.foodcourt.traceability.infrastructure.rest.dto;

public record ErrorApiResponse(
	int code,
	String message
) {}
