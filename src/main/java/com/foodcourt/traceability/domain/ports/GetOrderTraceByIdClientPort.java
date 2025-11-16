package com.foodcourt.traceability.domain.ports;

import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;

import java.util.List;

public interface GetOrderTraceByIdClientPort {
	
	List<OrderTraceSummary> execute(Long idClient);
	
}
