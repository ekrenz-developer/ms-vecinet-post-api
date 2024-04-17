package com.vecinet.post.domain.valueobject;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder()
public class PageableValueObject {
    private static final int DEFAULT_PAGE_NUMBER = 1;
    private static final int DEFAULT_PAGE_SIZE = 15;
    private static final String DEFAULT_SORT_BY = "createdAt";
    private static final SortDirection DEFAULT_SORT_DIRECTION = SortDirection.DESC;

    @Builder.Default
    private final int pageNumber = DEFAULT_PAGE_NUMBER;
    @Builder.Default
    private final int pageSize = DEFAULT_PAGE_SIZE;
    @Builder.Default
    private final String sortBy = DEFAULT_SORT_BY;
    @Builder.Default
    private final SortDirection sortDirection = DEFAULT_SORT_DIRECTION;

    public enum SortDirection {
        ASC,
        DESC
    }
}