package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
public class BaseQueryParamDto {
    @Min(1)
    private Integer page;
    @Max(50)
    private Integer size;
}
