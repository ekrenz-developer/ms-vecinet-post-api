package com.vecinet.post.infrastructure.mq.rabbit.config;

import com.vecinet.post.domain.port.EnvironmentConfigPort;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePostProducerConfig {
    private final EnvironmentConfigPort environmentConfig;

    public CreatePostProducerConfig(EnvironmentConfigPort environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    @Bean
    public Queue createPostQueue() {
        return new Queue(this.environmentConfig.getRabbitMQCreatePostQueue(), true);
    }

    @Bean
    public TopicExchange createPostExchange() {
        return new TopicExchange(this.environmentConfig.getRabbitMQCreatePostExchange());
    }

    @Bean
    public Binding createPostBinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(this.environmentConfig.getRabbitMQCreatePostRoutingKey());
    }
}
