package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import com.foodcourt.traceability.domain.ports.CreateOrderTracePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class CreateOrderTraceUseCase implements CreateOrderTracePort {
	
	private final TraceRepositoryGateway traceRepositoryGateway;
	
	@Override
	public void execute(OrderTrace orderTrace) {
		orderTrace.setDateTime(LocalDateTime.now());
		traceRepositoryGateway.save(orderTrace);
	}
	
}
