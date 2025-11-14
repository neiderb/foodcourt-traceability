package com.foodcourt.traceability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TraceabilityApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(
			TraceabilityApplication.class,
			args
		);
	}
	
}
