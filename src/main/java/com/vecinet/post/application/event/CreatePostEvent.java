package com.vecinet.post.application.event;

import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.EventPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePostEvent implements EventPort {
    private final PostEntity postEntity;

    @Override
    public PostEntity getData() {
        return this.postEntity;
    }
}
