package com.foodcourt.traceability.domain.model.ordertrace;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderTrace {

	private String id;
	private Long idOrder;
	private Long idClient;
	private String emailClient;
	private LocalDateTime dateTime;
	private String previousStatus;
	private String newStatus;
	private Long idEmployee;
	private String emailEmployee;
	private Long idRestaurant;

}
