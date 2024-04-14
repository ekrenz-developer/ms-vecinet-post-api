package com.vecinet.post.domain.port;

import com.vecinet.post.domain.entity.PostEntity;

public interface PostRespositoryPort {
    PostEntity create(PostEntity entity);
}
