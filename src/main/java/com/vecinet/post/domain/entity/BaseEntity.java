package com.vecinet.post.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
public abstract class BaseEntity {
    @Id
    @NonNull
    @Builder.Default
    protected UUID id = UUID.randomUUID();
    @NonNull
    @Builder.Default
    protected Date createdAt = new Date();
    @NonNull
    @Builder.Default
    protected Date updatedAt = new Date();
    protected Date deletedAt;
}
