package com.foodcourt.traceability.infrastructure.adapters.persistence.data;

import com.foodcourt.traceability.infrastructure.adapters.persistence.entity.OrderTraceData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderTraceDataRepository extends MongoRepository<OrderTraceData, String> {
	
	List<OrderTraceData> findAllByIdClientOrderByDateTimeDesc(Long idClient);
	
}
