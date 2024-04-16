package com.vecinet.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@Jacksonized
@ToString
public class BaseEntity {
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
