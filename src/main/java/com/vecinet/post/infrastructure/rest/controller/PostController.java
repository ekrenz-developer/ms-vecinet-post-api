package com.vecinet.post.infrastructure.rest.controller;

import com.vecinet.post.application.dto.CreatePostCommandDto;
import com.vecinet.post.application.dto.SearchPostQueryDto;
import com.vecinet.post.application.usecase.CreatePostUseCase;
import com.vecinet.post.application.usecase.SearchPostUseCase;
import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.valueobject.PageValueObject;
import com.vecinet.post.infrastructure.rest.dto.PageResponseDto;
import com.vecinet.post.infrastructure.rest.dto.PostBodyDto;
import com.vecinet.post.infrastructure.rest.dto.PostResponseDto;
import com.vecinet.post.infrastructure.rest.dto.PostSearchQueryParamDto;
import com.vecinet.post.infrastructure.rest.mapper.PostMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@Validated
public class PostController {
    private final CreatePostUseCase createPostUseCase;
    private final SearchPostUseCase searchPostUseCase;
    private final PostMapper postMapper;

    public PostController(CreatePostUseCase createPostUseCase, SearchPostUseCase searchPostUseCase, PostMapper postMapper) {
        this.createPostUseCase = createPostUseCase;
        this.searchPostUseCase = searchPostUseCase;
        this.postMapper = postMapper;
    }

    @PostMapping()
    public ResponseEntity<PostResponseDto> create(@RequestBody PostBodyDto payload) {
        PostEntity entity = this.postMapper.toEntity(payload);
        CreatePostCommandDto command = CreatePostCommandDto.builder().postEntity(entity).build();
        PostEntity createdPostEntity = this.createPostUseCase.execute(command);
        return new ResponseEntity<>(this.postMapper.toResponse(createdPostEntity), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponseDto<PostResponseDto>> search(@Validated @ModelAttribute  PostSearchQueryParamDto searchDto) {
        SearchPostQueryDto searchPostQueryValueObject = this.postMapper.toSearchPostQueryDto(searchDto);
        PageValueObject<PostEntity> postList = this.searchPostUseCase.execute(searchPostQueryValueObject);
        PageResponseDto<PostResponseDto> response = this.postMapper.toPageResponseDto(postList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
