package com.vecinet.post.infrastructure.config;


import com.vecinet.post.domain.port.EnvironmentConfigPort;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
public class EnvironmentConfig implements EnvironmentConfigPort {
    @Value("${server.port}")
    @NotBlank(message = "Server port must not be blank")
    private int serverPort;

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

    @Value("${environment.rabbitmq.host}")
    @NotBlank(message = "RabbitMQ host must not be blank")
    private String rabbitMQHost;

    @Value("${environment.rabbitmq.port}")
    @NotBlank(message = "RabbitMQ port must not be blank")
    private int rabbitMQPort;

    @Value("${environment.rabbitmq.username}")
    @NotBlank(message = "RabbitMQ username must not be blank")
    private String rabbitMQUsername;

    @Value("${environment.rabbitmq.password}")
    @NotBlank(message = "RabbitMQ password must not be blank")
    private String rabbitMQPassword;

    @Value("${environment.rabbitmq.create_post_queue}")
    @NotBlank(message = "RabbitMQ createPostQueue must not be blank")
    private String rabbitMQCreatePostQueue;

    @Value("${environment.rabbitmq.create_post_exchange}")
    @NotBlank(message = "RabbitMQ createPostExchange must not be blank")
    private String rabbitMQCreatePostExchange;

    @Value("${environment.rabbitmq.create_post_routing_key}")
    @NotBlank(message = "RabbitMQ createPostRoutingKey must not be blank")
    private String rabbitMQCreatePostRoutingKey;

    @Override
    public int getServerPort() {
        return this.serverPort;
    }

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

    @Override
    public String getRabbitMQHost() {
        return this.rabbitMQHost;
    }

    @Override
    public int getRabbitMQPort() {
        return this.rabbitMQPort;
    }

    @Override
    public String getRabbitMQUsername() {
        return this.rabbitMQUsername;
    }

    @Override
    public String getRabbitMQPassword() {
        return this.rabbitMQPassword;
    }

    @Override
    public String getRabbitMQCreatePostQueue() {
        return this.rabbitMQCreatePostQueue;
    }

    @Override
    public String getRabbitMQCreatePostExchange() {
        return this.rabbitMQCreatePostExchange;
    }

    @Override
    public String getRabbitMQCreatePostRoutingKey() {
        return this.rabbitMQCreatePostRoutingKey;
    }
}
