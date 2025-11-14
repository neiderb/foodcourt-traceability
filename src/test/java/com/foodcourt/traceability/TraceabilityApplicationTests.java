package com.foodcourt.traceability;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.mockito.Mockito.times;

class TraceabilityApplicationTests {
	
	@Test
	void shouldInvokeSpringApplicationRunWhenMainIsCalled() {
		try (MockedStatic<SpringApplication> springAppMock = Mockito.mockStatic(SpringApplication.class)) {
			springAppMock.when(() -> SpringApplication.run(Mockito.eq(TraceabilityApplication.class), Mockito.any(String[].class)))
				.thenReturn(Mockito.mock(ConfigurableApplicationContext.class));
			
			TraceabilityApplication.main(new String[]{});
			
			springAppMock.verify(() -> SpringApplication.run(Mockito.eq(TraceabilityApplication.class), Mockito.any(String[].class)), times(1));
		}
	}
	
}
