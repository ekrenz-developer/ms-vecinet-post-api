package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseQueryParamDto {
    @Min(1)
    protected Integer page;
    @Max(50)
    protected Integer size;
}
