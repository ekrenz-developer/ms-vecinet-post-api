package com.vecinet.post.infrastructure.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    private final EnvironmentConfig environmentConfig;

    public MongoConfig(EnvironmentConfig environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    @Bean
    public MongoClient mongoClient() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(this.getMongoUri()))
                .uuidRepresentation(UuidRepresentation.JAVA_LEGACY)
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), this.environmentConfig.getMongoDatabase());
    }

    private String getMongoUri() {
        return String.format("mongodb+srv://%s:%s@%s/%s", this.environmentConfig.getMongoUsername(), this.environmentConfig.getMongoPassword(), this.environmentConfig.getMongoCluster(), this.environmentConfig.getMongoDatabase());
    }
}
