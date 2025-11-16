package com.foodcourt.traceability.application.handler;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;

import java.util.List;

public interface OrderTraceHandler {
	
	void createTrace(CreateOrderTraceRequest request);
	
	List<OrderTraceSummary> getTracesByIdClient();
	
	List<OrderProcessingTimeReport> getOrderProcessingReport(Long idRestaurant);
	
	List<EmployeeRankingReport> getEmployeeRankingReport(Long idRestaurant);
	
}
