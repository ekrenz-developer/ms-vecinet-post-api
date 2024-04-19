package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PostSearchQueryParamDto extends BaseQueryParamDto {
    @NotNull
    private final String username;
    @NotNull
    private final Double latitude;
    @NotNull
    private final Double longitude;
    private int distanceInKm;
}
