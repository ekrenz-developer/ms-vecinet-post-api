package com.vecinet.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PostEntity extends BaseEntity {
    @NonNull
    @JsonProperty("username")
    private String username;
    @NonNull
    @JsonProperty("latitude")
    private Double latitude;
    @NonNull
    @JsonProperty("longitude")
    private Double longitude;
    @NonNull
    @JsonProperty("content")
    private String content;
}
