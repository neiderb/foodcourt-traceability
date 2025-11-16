package com.foodcourt.traceability.domain.ports;

import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;

import java.util.List;

public interface GetOrderProcessingReportPort {
	
	List<OrderProcessingTimeReport> execute(Long idRestaurant);
	
}
