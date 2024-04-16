package com.vecinet.post.infrastructure.persistence.mongo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@SuperBuilder
@Document("posts")
public class PostModel extends BaseModel {
    @NonNull
    private String username;
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
    @NonNull
    private String content;
    @GeoSpatialIndexed
    private GeoJsonPoint location;
}