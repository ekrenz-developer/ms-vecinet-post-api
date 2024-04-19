package com.vecinet.post.domain.valueobject;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder()
public class LocationSearchValueObject {
    private static final int DEFAULT_DISTANCE_IN_KM = 5;

    private final String username;
    private final Double latitude;
    private final Double longitude;
    private final String content;
    @Builder.Default
    private final int distanceInKm = DEFAULT_DISTANCE_IN_KM;
}
