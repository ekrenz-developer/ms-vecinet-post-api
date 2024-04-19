package com.vecinet.post.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageResponseDto<R> {
    private final List<R> content;
    private final PaginationMetadata metadata;

    @Getter
    @Builder
    public static class PaginationMetadata {
        private final int pageNumber;
        private final int pageSize;
        private final int totalElements;
        private final boolean hasPreviousPage;
        private final boolean hasNextPage;
    }
}