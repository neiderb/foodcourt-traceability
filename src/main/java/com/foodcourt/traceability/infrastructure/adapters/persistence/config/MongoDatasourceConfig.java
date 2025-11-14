package com.foodcourt.traceability.infrastructure.adapters.persistence.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.lang.NonNull;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MongoDatasourceConfig extends AbstractMongoClientConfiguration {
	
	private final DatabaseConnectionProperties properties;
	
	private static final int POOL_SIZE = 10;
	
	@Override
	@NonNull
	protected String getDatabaseName() {
		return properties.database();
	}
	
	@Bean
	@NonNull
	@Override
	public MongoClient mongoClient() {
		MongoCredential credential = MongoCredential.createCredential(
			properties.username(),
			properties.database(),
			properties.password().toCharArray()
		);
		
		MongoClientSettings settings = MongoClientSettings.builder()
			.applyToClusterSettings(builder ->
				builder.hosts(List.of(new ServerAddress(properties.host(), properties.port())))
			)
			.credential(credential)
			.applyToConnectionPoolSettings(builder -> builder.maxSize(POOL_SIZE))
			.build();
		
		return MongoClients.create(settings);
	}
	
}
