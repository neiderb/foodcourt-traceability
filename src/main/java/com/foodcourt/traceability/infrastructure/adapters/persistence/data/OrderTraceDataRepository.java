package com.foodcourt.traceability.infrastructure.adapters.persistence.data;

import com.foodcourt.traceability.infrastructure.adapters.persistence.entity.OrderTraceData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderTraceDataRepository extends MongoRepository<OrderTraceData, String> {
}
