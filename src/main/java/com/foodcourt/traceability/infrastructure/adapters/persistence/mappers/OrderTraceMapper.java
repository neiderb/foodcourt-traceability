package com.foodcourt.traceability.infrastructure.adapters.persistence.mappers;

import com.foodcourt.traceability.domain.model.ordertrace.OrderTrace;
import com.foodcourt.traceability.infrastructure.adapters.persistence.entity.OrderTraceData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderTraceMapper {
	
	OrderTraceMapper INSTANCE = Mappers.getMapper(OrderTraceMapper.class);
	
	OrderTraceData toData(OrderTrace orderTrace);
	
}
