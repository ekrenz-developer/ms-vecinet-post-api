package com.vecinet.post.domain.port;

import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.valueobject.PageValueObject;
import com.vecinet.post.domain.valueobject.PostSearchCriteriaValueObject;

public interface PostRespositoryPort {
    PageValueObject<PostEntity> search(PostSearchCriteriaValueObject criteria);
}
