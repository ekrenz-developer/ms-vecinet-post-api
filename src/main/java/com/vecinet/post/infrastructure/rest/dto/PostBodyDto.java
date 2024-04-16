package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class PostBodyDto {
    @NotNull
    @NonNull
    private Double latitude;
    @NotNull
    @NonNull
    private Double longitude;
    @NotBlank
    @NonNull
    private String content;
    @NotBlank
    @NonNull
    private String username;
}
