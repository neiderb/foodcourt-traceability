package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.exception.ordertrace.InvalidOrderTraceException;
import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;
import com.foodcourt.traceability.domain.ports.GetOrderTraceByIdClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.foodcourt.traceability.domain.constants.OrderTraceValidationMessage.INVALID_CLIENT_ID;
import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
public class GetOrderTraceByIdClientUseCase implements GetOrderTraceByIdClientPort {
	
	private final TraceRepositoryGateway traceRepositoryGateway;
	
	@Override
	public List<OrderTraceSummary> execute(Long idClient) {
		validateIdClient(idClient);
		return traceRepositoryGateway.findByIdClient(idClient);
	}
	
	private void validateIdClient(Long idClient) {
		if (isNull(idClient) || idClient <= 0)
			throw new InvalidOrderTraceException(INVALID_CLIENT_ID);
	}
}
