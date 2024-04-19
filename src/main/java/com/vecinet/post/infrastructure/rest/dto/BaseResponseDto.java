package com.vecinet.post.infrastructure.rest.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
public class BaseResponseDto {
    private final String id;
    private final Date createdAt;
    private final Date updatedAt;
    private Date deletedAt;
}
