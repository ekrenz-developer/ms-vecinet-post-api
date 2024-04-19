package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PostSearchQueryParamDto extends BaseQueryParamDto {
    @NotNull
    private String username;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    private int distanceInKm;
}
