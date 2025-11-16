package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.exception.ordertrace.InvalidOrderTraceException;
import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;
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
class GetEmployeeRankingReportUseCaseTest {
	
	@InjectMocks
	private GetEmployeeRankingReportUseCase getEmployeeRankingReportUseCase;
	
	@Mock
	private TraceRepositoryGateway traceRepositoryGateway;
	
	@Test
	void shouldReturnOrderTraceSummariesSuccessfully() {
		final Long idRestaurant = 1L;
		List<EmployeeRankingReport> expectedList = List.of(
			new EmployeeRankingReport(),
			new EmployeeRankingReport()
		);
		
		when(traceRepositoryGateway.getEmployeeRankingReport(any(Long.class))).thenReturn(expectedList);
		
		var actualList = getEmployeeRankingReportUseCase.execute(idRestaurant);
		
		assertNotNull(actualList);
		assertEquals(actualList.size(), expectedList.size());
		
		verify(traceRepositoryGateway).getEmployeeRankingReport(idRestaurant);
	}
	
	@Test
	void shouldThrowExceptionWhenIdClientIsInvalid() {
		assertAll(
			() -> assertThrows(InvalidOrderTraceException.class, () -> getEmployeeRankingReportUseCase.execute(null)),
			() -> assertThrows(InvalidOrderTraceException.class, () -> getEmployeeRankingReportUseCase.execute(0L)),
			() -> assertThrows(InvalidOrderTraceException.class, () -> getEmployeeRankingReportUseCase.execute(-5L))
		);
	}
	
}
