package com.vecinet.post.infrastructure.persistence.mongo.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
public abstract class BaseModel {
    @Id
    @NonNull
    protected UUID id;

    @Field("created_at")
    @Indexed
    @NonNull
    private Long createdAt;

    @Field("updated_at")
    @Indexed
    @NonNull
    private Long updatedAt;

    @Field("deleted_at")
    private Long deletedAt;

    public void setCreatedAt(Date date) {
        this.createdAt = date.getTime();
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date.getTime();
    }

    public void setDeletedAt(Date date) {
        if (date != null) {
            this.deletedAt = date.getTime();
        } else {
            this.deletedAt = null;
        }
    }

    public Date getCreatedAt() {
        return new Date(createdAt);
    }

    public Date getUpdatedAt() {
        return new Date(updatedAt);
    }

    public Date getDeletedAt() {
        return deletedAt != null ? new Date(deletedAt) : null;
    }
}
