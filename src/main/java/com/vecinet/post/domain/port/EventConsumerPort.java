package com.vecinet.post.domain.port;

public interface EventConsumerPort<E> {
    //    EventPort handleReceivedSyncEvent(EventPort event);
    void handleReceivedAsyncEvent(E event);
}
