package com.vecinet.post.infrastructure.config;


import com.vecinet.post.domain.port.EnvironmentConfigPort;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
public class EnvironmentConfig implements EnvironmentConfigPort {
    @Value("${environment.mongo.username}")
    @NotBlank(message = "Mongo username must not be blank")
    private String mongoUsername;

    @Value("${environment.mongo.password}")
    @NotBlank(message = "Mongo password must not be blank")
    private String mongoPassword;

    @Value("${environment.mongo.cluster}")
    @NotBlank(message = "Mongo cluster must not be blank")
    private String mongoCluster;

    @Value("${environment.mongo.database}")
    @NotBlank(message = "Mongo database must not be blank")
    private String mongoDatabase;

    @Override
    public String getMongoUsername() {
        return this.mongoUsername;
    }

    @Override
    public String getMongoPassword() {
        return this.mongoPassword;
    }

    @Override
    public String getMongoCluster() {
        return this.mongoCluster;
    }

    @Override
    public String getMongoDatabase() {
        return this.mongoDatabase;
    }
}
