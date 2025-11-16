package com.foodcourt.traceability.infrastructure.rest;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.application.handler.OrderTraceHandler;
import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.foodcourt.traceability.infrastructure.rest.constants.paths.TracePath.*;
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
	
	@Operation(summary = GET_ORDER_TRACES_SUMMARY)
	@ApiResponse(
		responseCode = "200",
		description = GET_ORDER_TRACES_DESCRIPTION
	)
	@GetMapping
	ResponseEntity<List<OrderTraceSummary>> getOrderTrace() {
		log.trace("getOrderTrace");
		return ResponseEntity.ok(orderTraceHandler.getTracesByIdClient());
	}
	
	@Operation(summary = GET_ORDER_PROCESSING_REPORT_SUMMARY)
	@ApiResponse(
		responseCode = "200",
		description = GET_ORDER_PROCESSING_REPORT_DESCRIPTION
	)
	@GetMapping(ORDER_PROCESSING_REPORT)
	ResponseEntity<List<OrderProcessingTimeReport>> getOrderProccessingTimeReport(@PathVariable Long idRestaurant) {
		log.trace("getOrderProccessingTimeReport");
		return ResponseEntity.ok(orderTraceHandler.getOrderProcessingReport(idRestaurant));
	}
	
	@Operation(summary = GET_EMPLOYEE_RANKING_SUMMARY)
	@ApiResponse(
		responseCode = "200",
		description = GET_EMPLOYEE_RANKING_DESCRIPTION
	)
	@GetMapping(EMPLOYEE_RANKING_REPORT)
	ResponseEntity<List<EmployeeRankingReport>> getEmployeeRankingReport(@PathVariable Long idRestaurant) {
		log.trace("getEmployeeRankingReport");
		return ResponseEntity.ok(orderTraceHandler.getEmployeeRankingReport(idRestaurant));
	}
	
}
