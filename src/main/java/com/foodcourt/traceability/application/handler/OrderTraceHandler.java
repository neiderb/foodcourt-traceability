package com.foodcourt.traceability.application.handler;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;

import java.util.List;

public interface OrderTraceHandler {
	
	void createTrace(CreateOrderTraceRequest request);
	
	List<OrderTraceSummary> getTracesByIdClient();
	
}
