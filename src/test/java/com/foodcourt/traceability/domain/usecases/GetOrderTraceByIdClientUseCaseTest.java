package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.exception.ordertrace.InvalidOrderTraceException;
import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTraceSummary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOrderTraceByIdClientUseCaseTest {
	
	@InjectMocks
	private GetOrderTraceByIdClientUseCase getOrderTraceByIdClientUseCase;
	
	@Mock
	private TraceRepositoryGateway traceRepositoryGateway;
	
	@Test
	void shouldReturnOrderTraceSummariesSuccessfully() {
		final Long idClient = 1L;
		List<OrderTraceSummary> expectedList = List.of(
			OrderTraceSummary.builder()
				.idOrderTrace("uuid1")
				.build(),
			OrderTraceSummary.builder()
				.idOrderTrace("uuid2")
				.build()
		);
		
		when(traceRepositoryGateway.findByIdClient(any(Long.class))).thenReturn(expectedList);
		
		var actualList = getOrderTraceByIdClientUseCase.execute(idClient);
		
		assertNotNull(actualList);
		assertEquals(actualList.size(), expectedList.size());
	}
	
	@Test
	void shouldThrowExceptionWhenIdClientIsInvalid() {
		assertAll(
			() -> assertThrows(InvalidOrderTraceException.class, () -> getOrderTraceByIdClientUseCase.execute(null)),
			() -> assertThrows(InvalidOrderTraceException.class, () -> getOrderTraceByIdClientUseCase.execute(0L)),
			() -> assertThrows(InvalidOrderTraceException.class, () -> getOrderTraceByIdClientUseCase.execute(-5L))
		);
	}
	
}
