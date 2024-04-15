package com.vecinet.post.infrastructure.mq.rabbit.consumer;

import com.vecinet.post.application.event.CreatePostEvent;
import com.vecinet.post.domain.port.EventConsumerPort;
import com.vecinet.post.domain.port.EventPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CreatePostEventConsumer implements EventConsumerPort<CreatePostEvent> {
    @RabbitListener(queues = "#{createPostConfig.createPostQueue().getName()}")
    @Override
    public void handleReceivedAsyncEvent(CreatePostEvent event) {
        System.out.println("Received event: " + event.getData());
    }
}
