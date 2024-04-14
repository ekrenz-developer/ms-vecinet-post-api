package com.vecinet.post.infrastructure.rest.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PostResponseDto extends BaseResponseDto {
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
    @NonNull
    private String content;
    @NonNull
    private String username;
}
