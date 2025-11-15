package com.foodcourt.traceability.domain.usecases;

import com.foodcourt.traceability.domain.gateways.TraceRepositoryGateway;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateOrderTraceUseCaseTest {
	
	@InjectMocks
	private CreateOrderTraceUseCase createOrderTraceUseCase;
	
	@Mock
	private TraceRepositoryGateway traceRepositoryGateway;
	
	@Test
	void shouldCreateOrderTraceSuccessfully() {
		OrderTrace trace = OrderTrace.builder()
			.emailClient("client@mail.com")
			.build();
		
		createOrderTraceUseCase.execute(trace);
		
		verify(traceRepositoryGateway).save(assertArg(traceArg -> {
			assertEquals(trace.getEmailClient(), traceArg.getEmailClient());
			assertNotNull(traceArg.getDateTime());
		}));
	}
}
