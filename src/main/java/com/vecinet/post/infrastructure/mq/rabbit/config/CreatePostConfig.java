package com.vecinet.post.infrastructure.mq.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePostConfig {
    public static final String QUEUE_NAME = "appQueue";
    public static final String EXCHANGE_NAME = "appExchange";
    public static final String ROUTING_KEY = "appKey";

    @Bean
    public Queue createPostQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange createPostExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding createPostBinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
}
