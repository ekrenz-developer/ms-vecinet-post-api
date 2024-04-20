package com.vecinet.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Getter
@SuperBuilder
@Jacksonized
@ToString
public class BaseEntity {
    @Id
    @Builder.Default
    @JsonProperty("id")
    protected final UUID id = UUID.randomUUID();
    @Builder.Default
    @JsonProperty("createdAt")
    protected final Date createdAt = new Date();
    @Builder.Default
    @JsonProperty("updatedAt")
    protected final Date updatedAt = new Date();
    @JsonProperty("deletedAt")
    protected Date deletedAt;
}
