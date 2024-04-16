package com.vecinet.post.domain.port;

public interface UseCasePort<I, O> {
    O execute(I input);
}
