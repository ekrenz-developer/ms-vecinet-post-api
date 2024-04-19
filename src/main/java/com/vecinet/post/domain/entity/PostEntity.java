package com.vecinet.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@SuperBuilder
@Jacksonized
@ToString(callSuper = true)
public class PostEntity extends BaseEntity {
    @JsonProperty("username")
    private final String username;
    @JsonProperty("latitude")
    private final Double latitude;
    @JsonProperty("longitude")
    private final Double longitude;
    @JsonProperty("content")
    private final String content;
}
