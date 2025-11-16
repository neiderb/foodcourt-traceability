package com.foodcourt.traceability.infrastructure.adapters.persistence;

import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;
import com.foodcourt.traceability.infrastructure.adapters.persistence.data.OrderTraceDataRepository;
import com.foodcourt.traceability.infrastructure.adapters.persistence.mappers.OrderTraceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

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
	
	@Override
	public List<OrderTraceSummary> findByIdClient(Long idClient) {
		return orderTraceDataRepository.findAllByIdClientOrderByDateTimeDesc(idClient)
			.stream()
			.map(OrderTraceMapper.INSTANCE::toDomainSummary)
			.toList();
	}
	
	@Override
	public List<OrderProcessingTimeReport> getOrderProcessingTimeReport(Long idRestaurant) {
		return orderTraceDataRepository.getOrderProcessingTimeReport(idRestaurant);
	}
	
	@Override
	public List<EmployeeRankingReport> getEmployeeRankingReport(Long idRestaurant) {
		return orderTraceDataRepository.getEmployeeRankingReport(idRestaurant);
	}
	
}
