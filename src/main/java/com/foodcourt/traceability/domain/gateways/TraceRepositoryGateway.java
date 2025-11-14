package com.foodcourt.traceability.domain.gateways;

import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;

public interface TraceRepositoryGateway {
	
	void save(OrderTrace orderTrace);
	
}
