package com.vecinet.post.infrastructure.mq.rabbit.consumer;

import com.vecinet.post.application.event.CreatePostEvent;
import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.EventConsumerPort;
import com.vecinet.post.domain.port.PostRespositoryPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CreatePostEventConsumer implements EventConsumerPort<CreatePostEvent> {
    private final PostRespositoryPort postRepository;

    public CreatePostEventConsumer(PostRespositoryPort postRepository) {
        this.postRepository = postRepository;
    }

    @RabbitListener(queues = "#{createPostConfig.createPostQueue().getName()}")
    @Override
    public void handleReceivedAsyncEvent(CreatePostEvent event) {
        PostEntity postEntity = event.getData();
        this.postRepository.create(postEntity);
    }
}
