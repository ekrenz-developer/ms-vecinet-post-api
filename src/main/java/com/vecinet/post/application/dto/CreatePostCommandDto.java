package com.vecinet.post.application.dto;

import com.vecinet.post.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class CreatePostCommandDto {
    @NonNull
    private PostEntity postEntity;
}
