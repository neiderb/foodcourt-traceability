package com.foodcourt.traceability.infrastructure.adapters.persistence;

import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import com.foodcourt.traceability.infrastructure.adapters.persistence.data.OrderTraceDataRepository;
import com.foodcourt.traceability.infrastructure.adapters.persistence.mappers.OrderTraceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderTraceRepositoryAdapter implements TraceRepositoryGateway {
	
	private final OrderTraceDataRepository orderTraceDataRepository;
	
	@Override
	public void save(OrderTrace orderTrace) {
		log.trace("Saving order trace: {}", orderTrace);
		orderTraceDataRepository.save(
			OrderTraceMapper.INSTANCE.toData(orderTrace)
		);
	}
	
}
