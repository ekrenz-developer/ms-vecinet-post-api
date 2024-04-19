package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseQueryParamDto {
    @Min(1)
    private int page;
    @Max(50)
    private int size;
}
