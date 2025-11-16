package com.foodcourt.traceability.application.config;

import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.ports.CreateOrderTracePort;
import com.foodcourt.traceability.domain.ports.GetEmployeeRankingReportPort;
import com.foodcourt.traceability.domain.ports.GetOrderProcessingReportPort;
import com.foodcourt.traceability.domain.ports.GetOrderTraceByIdClientPort;
import com.foodcourt.traceability.domain.usecases.CreateOrderTraceUseCase;
import com.foodcourt.traceability.domain.usecases.GetEmployeeRankingReportUseCase;
import com.foodcourt.traceability.domain.usecases.GetOrderProcessingReportUseCase;
import com.foodcourt.traceability.domain.usecases.GetOrderTraceByIdClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderTraceBeanConfig {
	
	@Bean
	public CreateOrderTracePort createOrderTracePort(
		TraceRepositoryGateway traceRepositoryGateway
	) {
		return new CreateOrderTraceUseCase(
			traceRepositoryGateway
		);
	}
	
	@Bean
	public GetOrderTraceByIdClientPort getOrderTraceByIdClientPort(
		TraceRepositoryGateway traceRepositoryGateway
	) {
		return new GetOrderTraceByIdClientUseCase(
			traceRepositoryGateway
		);
	}
	
	@Bean
	public GetOrderProcessingReportPort getOrderProcessingReportPort(
		TraceRepositoryGateway traceRepositoryGateway
	) {
		return new GetOrderProcessingReportUseCase(
			traceRepositoryGateway
		);
	}
	
	@Bean
	public GetEmployeeRankingReportPort getEmployeeRankingReportPort(
		TraceRepositoryGateway traceRepositoryGateway
	) {
		return new GetEmployeeRankingReportUseCase(
			traceRepositoryGateway
		);
	}
	
}
