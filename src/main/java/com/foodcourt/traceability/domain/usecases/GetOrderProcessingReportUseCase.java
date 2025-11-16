package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.exception.ordertrace.InvalidOrderTraceException;
import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import com.foodcourt.traceability.domain.ports.GetOrderProcessingReportPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.foodcourt.traceability.domain.constants.OrderTraceValidationMessage.INVALID_RESTAURANT_ID;
import static java.util.Objects.isNull;

@RequiredArgsConstructor
public class GetOrderProcessingReportUseCase implements GetOrderProcessingReportPort {
	
	private final TraceRepositoryGateway traceRepositoryGateway;
	
	@Override
	public List<OrderProcessingTimeReport> execute(Long idRestaurant) {
		validateIdRestaurant(idRestaurant);
		return traceRepositoryGateway.getOrderProcessingTimeReport(idRestaurant);
	}
	
	private void validateIdRestaurant(Long idRestaurant) {
		if (isNull(idRestaurant) || idRestaurant <= 0)
			throw new InvalidOrderTraceException(INVALID_RESTAURANT_ID);
	}
	
}
