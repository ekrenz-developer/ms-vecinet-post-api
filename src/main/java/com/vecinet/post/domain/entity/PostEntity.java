package com.vecinet.post.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Date;
import java.util.UUID;

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
