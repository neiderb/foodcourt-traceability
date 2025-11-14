package com.foodcourt.traceability.infrastructure.rest;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.application.handler.OrderTraceHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.foodcourt.traceability.infrastructure.rest.constants.paths.TracePath.BASE;
import static com.foodcourt.traceability.infrastructure.rest.docapi.OrderTraceDocApi.*;

@Slf4j
@Tag(name = TAG_ORDER_TRACE)
@RestController
@RequiredArgsConstructor
@RequestMapping(BASE)
public class OrderTraceController {
	
	private final OrderTraceHandler orderTraceHandler;
	
	@Operation(summary = CREATE_ORDER_TRACE_SUMMARY)
	@ApiResponse(
		responseCode = "201",
		description = CREATE_ORDER_TRACE_DESCRIPTION
	)
	@PostMapping
	ResponseEntity<Void> createOrderTrace(@RequestBody CreateOrderTraceRequest createOrderTraceRequest) {
		log.trace("createOrderTrace: {}", createOrderTraceRequest);
		orderTraceHandler.createTrace(createOrderTraceRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
