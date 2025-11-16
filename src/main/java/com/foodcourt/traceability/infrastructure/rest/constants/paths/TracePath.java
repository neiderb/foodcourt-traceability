package com.foodcourt.traceability.infrastructure.rest.constants.paths;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TracePath {
	
	public static final String BASE = "/api/v1/trace";
	
	public static final String ORDER_PROCESSING_REPORT = "/order-processing-report/{idRestaurant}";
	public static final String EMPLOYEE_RANKING_REPORT = "/employee-ranking-report/{idRestaurant}";
	
}
