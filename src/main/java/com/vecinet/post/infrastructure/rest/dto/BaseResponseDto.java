package com.vecinet.post.infrastructure.rest.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class BaseResponseDto {
    @NonNull
    private String id;
    @NonNull
    private Date createdAt;
    @NonNull
    private Date updatedAt;
    private Date deletedAt;
}
