package com.vecinet.post.application.usecase;

import com.vecinet.post.application.dto.SearchPostQueryDto;
import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.PostRespositoryPort;
import com.vecinet.post.domain.port.UseCasePort;
import com.vecinet.post.domain.valueobject.PageValueObject;
import org.springframework.stereotype.Service;

@Service
public class SearchPostUseCase implements UseCasePort<SearchPostQueryDto, PageValueObject<PostEntity>> {
    private final PostRespositoryPort postRepository;

    public SearchPostUseCase(PostRespositoryPort postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PageValueObject<PostEntity> execute(SearchPostQueryDto payload) {
        return this.postRepository.search(payload);
    }
}