package com.foodcourt.traceability.application.handler;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;

public interface OrderTraceHandler {
	
	void createTrace(CreateOrderTraceRequest request);
	
}
