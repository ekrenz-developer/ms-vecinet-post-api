package com.vecinet.post.infrastructure.persistence.mongo.model;

import com.vecinet.post.domain.entity.BaseEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
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

    public PostModel(@NonNull UUID id, @NonNull Long createdAt, @NonNull Long updatedAt, Long deletedAt, @NonNull String username, @NonNull Double latitude, @NonNull Double longitude, @NonNull String content) {
        super(id, createdAt, updatedAt, deletedAt);
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
        this.content = content;
        this.location = new GeoJsonPoint(longitude, latitude);
    }
}