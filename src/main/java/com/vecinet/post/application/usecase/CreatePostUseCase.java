package com.vecinet.post.application.usecase;

import com.vecinet.post.application.dto.CreatePostCommandDto;
import com.vecinet.post.application.event.CreatePostEvent;
import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.EventProducerPort;
import com.vecinet.post.domain.port.UseCasePort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreatePostUseCase implements UseCasePort<CreatePostCommandDto, PostEntity> {
    private final EventProducerPort eventProducer;

    public CreatePostUseCase(@Qualifier("createPostEventProducer") EventProducerPort eventProducer) {
        this.eventProducer = eventProducer;
    }

    @Override
    public PostEntity execute(CreatePostCommandDto command) {
        PostEntity postEntity = command.getPostEntity();
        CreatePostEvent event = new CreatePostEvent(postEntity);
        this.eventProducer.sendAsyncEvent(event);
        return postEntity;
    }
}
