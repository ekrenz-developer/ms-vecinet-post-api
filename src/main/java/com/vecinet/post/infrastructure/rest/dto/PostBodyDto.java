package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostBodyDto {
    @NotNull
    private final Double latitude;
    @NotNull
    private final Double longitude;
    @NotBlank
    private final String content;
    @NotBlank
    private final String username;
}
