package com.vecinet.post.infrastructure.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vecinet.post.domain.port.EnvironmentConfigPort;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final EnvironmentConfigPort environmentConfig;

    public RabbitMQConfig(EnvironmentConfigPort environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.environmentConfig.getRabbitMQHost(), this.environmentConfig.getRabbitMQPort());
        connectionFactory.setUsername(this.environmentConfig.getRabbitMQUsername());
        connectionFactory.setPassword(this.environmentConfig.getRabbitMQPassword());
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(producerJackson2MessageConverter());
        return template;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  // Registro del módulo para manejo de fechas
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Configuración para usar ISO-8601 para fechas
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);  // Ignorar propiedades desconocidas
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
