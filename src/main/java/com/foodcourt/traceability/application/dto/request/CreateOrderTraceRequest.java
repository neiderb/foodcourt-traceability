package com.foodcourt.traceability.application.dto.request;

public record CreateOrderTraceRequest(
	Long idOrder,
	Long idClient,
	String emailClient,
	String previousStatus,
	String newStatus,
	Long idEmployee,
	String emailEmployee
) {}
