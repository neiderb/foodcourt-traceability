package com.foodcourt.traceability.domain.gateways;

import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;

import java.util.List;

public interface TraceRepositoryGateway {
	
	void save(OrderTrace orderTrace);
	
	List<OrderTraceSummary> findByIdClient(Long idClient);
	
}
