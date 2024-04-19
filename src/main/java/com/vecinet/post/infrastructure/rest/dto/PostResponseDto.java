package com.vecinet.post.infrastructure.rest.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PostResponseDto extends BaseResponseDto {
    private final Double latitude;
    private final Double longitude;
    private final String content;
    private final String username;
}
