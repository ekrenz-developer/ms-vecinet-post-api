package com.vecinet.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    protected UUID id = UUID.randomUUID();
    @NonNull
    @Builder.Default
    @JsonProperty("createdAt")
    protected Date createdAt = new Date();
    @NonNull
    @Builder.Default
    @JsonProperty("updatedAt")
    protected Date updatedAt = new Date();
    @JsonProperty("deletedAt")
    protected Date deletedAt;
}
