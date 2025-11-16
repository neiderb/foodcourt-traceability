package com.foodcourt.traceability.domain.model.ordertrace;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderTraceSummary {
	
	private String idOrderTrace;
	private String previousStatus;
	private String newStatus;
	private LocalDateTime dateTime;
	private String emailEmployee;
	
}
