package com.vecinet.post.application.usecase;

import com.vecinet.post.application.dto.CreatePostCommandDto;
import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.PostRespositoryPort;
import com.vecinet.post.domain.port.UseCasePort;
import org.springframework.stereotype.Service;

@Service
public class CreatePostUseCase implements UseCasePort<CreatePostCommandDto, PostEntity> {
    private final PostRespositoryPort postRepository;

    public CreatePostUseCase(PostRespositoryPort postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostEntity execute(CreatePostCommandDto command) {
        return this.postRepository.create(command.getPostEntity());
    }
}
