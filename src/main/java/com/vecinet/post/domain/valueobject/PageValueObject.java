package com.vecinet.post.domain.valueobject;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageValueObject<T> {
    private List<T> content;
    private final int pageNumber;
    private final int pageSize;
    private final int totalElements;
    private final Boolean hasPreviousPage;
    private final Boolean hasNextPage;
}
