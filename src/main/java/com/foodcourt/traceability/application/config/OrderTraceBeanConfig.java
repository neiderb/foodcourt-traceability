package com.foodcourt.traceability.application.config;

import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.ports.CreateOrderTracePort;
import com.foodcourt.traceability.domain.usecases.CreateOrderTraceUseCase;
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
	
}
