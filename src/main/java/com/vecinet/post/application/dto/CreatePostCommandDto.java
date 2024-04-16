package com.vecinet.post.application.dto;

import com.vecinet.post.domain.entity.PostEntity;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreatePostCommandDto {
    @NonNull
    private PostEntity postEntity;
}
