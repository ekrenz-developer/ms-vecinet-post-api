package com.vecinet.post.domain.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @NonNull
    protected UUID id;
    @NonNull
    protected Date createdAt;
    @NonNull
    protected Date updatedAt;
    protected Date deletedAt;

    protected BaseEntity()
    {
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.deletedAt = null;
    }
}
