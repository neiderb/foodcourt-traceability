package com.foodcourt.traceability.infrastructure.adapters.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "order_traces")
public class OrderTraceData {
	
	@Id
	private String id;
	private Long idOrder;
	private Long idClient;
	private String emailClient;
	private LocalDateTime dateTime;
	private String previousStatus;
	private String newStatus;
	private Long idEmployee;
	private String emailEmployee;
	
}
