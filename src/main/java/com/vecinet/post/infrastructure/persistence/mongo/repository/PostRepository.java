package com.vecinet.post.infrastructure.persistence.mongo.repository;

import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.PostRespositoryPort;
import com.vecinet.post.infrastructure.persistence.mongo.mapper.PostMapper;
import com.vecinet.post.infrastructure.persistence.mongo.model.PostModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository implements PostRespositoryPort {
    private final MongoTemplate mongoTemplate;
    private final PostMapper postMapper;

    public PostRepository(MongoTemplate mongoTemplate, PostMapper postMapper) {
        this.mongoTemplate = mongoTemplate;
        this.postMapper = postMapper;
    }

    @Override
    public PostEntity create(PostEntity entity) {
        PostModel postModel = this.mongoTemplate.save(this.postMapper.toPersistence(entity));
        return this.postMapper.toDomain(postModel);
    }
}
