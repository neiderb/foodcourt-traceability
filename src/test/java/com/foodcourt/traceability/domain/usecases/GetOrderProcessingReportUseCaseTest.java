package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.exception.ordertrace.InvalidOrderTraceException;
import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOrderProcessingReportUseCaseTest {
	
	@InjectMocks
	private GetOrderProcessingReportUseCase getOrderProcessingReportUseCase;
	
	@Mock
	private TraceRepositoryGateway traceRepositoryGateway;
	
	@Test
	void shouldReturnOrderProcessingTimeReportSuccessfully() {
		final Long idRestaurant = 1L;
		List<OrderProcessingTimeReport> expectedList = List.of(
			new OrderProcessingTimeReport(),
			new OrderProcessingTimeReport()
		);
		
		when(traceRepositoryGateway.getOrderProcessingTimeReport(any(Long.class))).thenReturn(expectedList);
		
		var actualList = getOrderProcessingReportUseCase.execute(idRestaurant);
		
		assertNotNull(actualList);
		assertEquals(actualList.size(), expectedList.size());
		
		verify(traceRepositoryGateway).getOrderProcessingTimeReport(idRestaurant);
	}
	
	@Test
	void shouldThrowExceptionWhenIdRestaurantIsInvalid() {
		assertAll(
			() -> assertThrows(InvalidOrderTraceException.class, () -> getOrderProcessingReportUseCase.execute(null)),
			() -> assertThrows(InvalidOrderTraceException.class, () -> getOrderProcessingReportUseCase.execute(0L)),
			() -> assertThrows(InvalidOrderTraceException.class, () -> getOrderProcessingReportUseCase.execute(-5L))
		);
	}
	
}
