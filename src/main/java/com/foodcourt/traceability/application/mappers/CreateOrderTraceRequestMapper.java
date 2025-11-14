package com.foodcourt.traceability.application.mappers;

import com.foodcourt.traceability.application.dto.request.CreateOrderTraceRequest;
import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateOrderTraceRequestMapper {
	
	CreateOrderTraceRequestMapper INSTANCE = Mappers.getMapper(CreateOrderTraceRequestMapper.class);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dateTime", ignore = true)
	OrderTrace toDomain(CreateOrderTraceRequest request);
	
}
