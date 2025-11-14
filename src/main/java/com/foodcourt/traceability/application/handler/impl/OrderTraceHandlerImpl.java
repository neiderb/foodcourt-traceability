package com.foodcourt.traceability.application.handler.impl;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.application.handler.OrderTraceHandler;
import com.foodcourt.traceability.application.mappers.CreateOrderTraceRequestMapper;
import com.foodcourt.traceability.domain.ports.CreateOrderTracePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderTraceHandlerImpl implements OrderTraceHandler {
	
	private final CreateOrderTracePort createOrderTracePort;
	
	@Override
	public void createTrace(CreateOrderTraceRequest request) {
		log.trace("Creating order trace: {}", request);
		createOrderTracePort.execute(
			CreateOrderTraceRequestMapper.INSTANCE.toDomain(request)
		);
	}
	
}
