package com.foodcourt.traceability.domain.ports;

import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;

public interface CreateOrderTracePort {
	
	void execute(OrderTrace orderTrace);
	
}
