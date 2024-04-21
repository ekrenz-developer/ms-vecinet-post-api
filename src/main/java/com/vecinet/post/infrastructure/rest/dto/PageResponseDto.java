package com.vecinet.post.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;



@Getter
@Builder
public class PageResponseDto<R> {

    @NonNull
    private List<R> content;
    @NonNull
    private PaginationMetadata metadata;

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
