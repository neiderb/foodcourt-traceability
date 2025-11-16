package com.foodcourt.traceability.domain.ports;

import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;

import java.util.List;

public interface GetEmployeeRankingReportPort {
	
	List<EmployeeRankingReport> execute(Long idRestaurant);
	
}
