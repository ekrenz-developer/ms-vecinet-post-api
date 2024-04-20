package com.vecinet.post.domain.valueobject;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PostSearchCriteriaValueObject {
    private PageableValueObject pageable;
    private final LocationSearchValueObject locationSearch;
}
