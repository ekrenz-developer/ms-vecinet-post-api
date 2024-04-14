package com.vecinet.post.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class PostEntity extends BaseEntity {
    @NonNull
    private String username;
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
    @NonNull
    private String content;
}
