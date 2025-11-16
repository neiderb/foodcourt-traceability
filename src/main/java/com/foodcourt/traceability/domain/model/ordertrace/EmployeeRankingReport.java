package com.foodcourt.traceability.domain.model.ordertrace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRankingReport {
	
	private Long idEmployee;
	private String emailEmployee;
	private Double averageTimeInMinutes;
	
}
