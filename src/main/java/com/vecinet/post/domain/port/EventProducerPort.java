package com.vecinet.post.domain.port;

public interface EventProducerPort {
//    EventPort sendSyncEvent(EventPort event);
    void sendAsyncEvent(EventPort event);
}
