package com.foodcourt.traceability.infrastructure.adapters.persistence.data;

import com.foodcourt.traceability.domain.model.ordertrace.EmployeeRankingReport;
import com.foodcourt.traceability.domain.model.ordertrace.OrderProcessingTimeReport;
import com.foodcourt.traceability.infrastructure.adapters.persistence.entity.OrderTraceData;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderTraceDataRepository extends MongoRepository<OrderTraceData, String> {
	
	List<OrderTraceData> findAllByIdClientOrderByDateTimeDesc(Long idClient);
	
	@Aggregation(pipeline = {
		"""
		  {
		    '$match': {
		      '$and': [
		        { 'newStatus': { '$in': [ 'PROCESSING', 'COMPLETED' ] } },
		        { 'idRestaurant': ?0 }
		      ],
		    }
		  }
		""",
		"""
		  {
		    '$group': {
		      '_id': '$idOrder',
		      'dateTimeStart': { '$min': '$dateTime' },
		      'dateTimeEnd': { '$max': '$dateTime' }
		    }
		  }
		""",
		"""
		  {
		    '$project': {
		      'idOrder': '$_id',
		      'averageProcessingTimeInMinutes': {
		        '$round': [
		          {
		            '$divide': [
		              { '$subtract': [ '$dateTimeEnd', '$dateTimeStart' ] },
		              60000
		            ],
		          }, 2
		        ],
		      }
		    }
		  }
		"""
	})
	List<OrderProcessingTimeReport> getOrderProcessingTimeReport(Long idRestaurant);
	
	@Aggregation(pipeline = {
		"{ '$match': { '$and': [ { 'newStatus': 'COMPLETED' }, { 'idRestaurant': ?0 } ] } }",
		"""
		  {
		    '$lookup':{
		      'from': 'order_traces',
		      'localField': 'idOrder',
		      'foreignField': 'idOrder',
		      'pipeline': [
		        {
		          '$match': {
		            '$and': [
		              { 'newStatus': { '$in': [ 'PROCESSING', 'COMPLETED' ] } },
		              { 'idRestaurant': ?0 }
		            ],
		          },
		        },
		        {
		          '$group': {
		            '_id': '$idOrder',
		            'dateTimeStart': { '$min': '$dateTime' },
		            'dateTimeEnd': { '$max': '$dateTime' }
		          },
		        },
		        {
		          '$project': {
		            '_id': 0,
		            'averageTimeInMinutes': {
		              '$divide': [
		                { '$subtract': [ '$dateTimeEnd', '$dateTimeStart' ] },
		                60000
		              ]
		            }
		          }
		        }
		      ],
		      'as': 'processingTime'
		    }
		  }
		""",
		"{ '$unwind': '$processingTime' }",
		"""
		  {
		    '$group': {
		      '_id': '$idEmployee',
		      'emailEmployee': { '$first': '$emailEmployee' },
		      'averageTimeInMinutes': { '$avg': '$processingTime.averageTimeInMinutes' }
		    }
		  }
		""",
		"{ '$sort': { 'averageTimeInMinutes': 1 } }",
		"""
		  {
		    '$project': {
		      '_id': 0,
		      'idEmployee': '$_id',
		      'emailEmployee': '$emailEmployee',
		      'averageTimeInMinutes': { '$round': [ '$averageTimeInMinutes', 2 ] }
		    }
		  }
		"""
	})
	List<EmployeeRankingReport> getEmployeeRankingReport(Long idRestaurant);
	
}
