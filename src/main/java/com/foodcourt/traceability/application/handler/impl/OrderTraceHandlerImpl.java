package com.foodcourt.traceability.application.handler.impl;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.application.handler.OrderTraceHandler;
import com.foodcourt.traceability.application.mappers.CreateOrderTraceRequestMapper;
import com.foodcourt.traceability.domain.model.auth.UserClaims;
import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;
import com.foodcourt.traceability.domain.ports.CreateOrderTracePort;
import com.foodcourt.traceability.domain.ports.GetEmployeeRankingReportPort;
import com.foodcourt.traceability.domain.ports.GetOrderProcessingReportPort;
import com.foodcourt.traceability.domain.ports.GetOrderTraceByIdClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderTraceHandlerImpl implements OrderTraceHandler {
	
	private final CreateOrderTracePort createOrderTracePort;
	private final GetOrderTraceByIdClientPort getOrderTraceByIdClientPort;
	private final GetOrderProcessingReportPort getOrderProcessingReportPort;
	private final GetEmployeeRankingReportPort getEmployeeRankingReportPort;
	
	@Override
	public void createTrace(CreateOrderTraceRequest request) {
		log.trace("Creating order trace: {}", request);
		createOrderTracePort.execute(
			CreateOrderTraceRequestMapper.INSTANCE.toDomain(request)
		);
	}
	
	@Override
	public List<OrderTraceSummary> getTracesByIdClient() {
		log.trace("Getting order traces for client ID: {}", getIdClient());
		return getOrderTraceByIdClientPort.execute(getIdClient());
	}
	
	@Override
	public List<OrderProcessingTimeReport> getOrderProcessingReport(Long idRestaurant) {
		log.trace("Getting order processing report");
		return getOrderProcessingReportPort.execute(idRestaurant);
	}
	
	@Override
	public List<EmployeeRankingReport> getEmployeeRankingReport(Long idRestaurant) {
		log.trace("Getting employee ranking report");
		return getEmployeeRankingReportPort.execute(idRestaurant);
	}
	
	private Long getIdClient() {
		Long idClient = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserClaims userClaims) {
			idClient = userClaims.id();
		}
		return idClient;
	}
}
