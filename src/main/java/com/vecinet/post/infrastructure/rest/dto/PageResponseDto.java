package com.vecinet.post.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;



@Getter
@AllArgsConstructor
public class PageResponseDto<R> {

    @NonNull
    private List<R> content;
    @NonNull
    private PaginationMetadata metadata;

    public record PaginationMetadata(int pageNumber, int pageSize, long totalElements,
                                     boolean hasPreviousPage, boolean hasNextPage) {
    }

    private boolean yatusabe(){

        int numeroPrimitivo = 1;
        Integer numeroObjeto = numeroPrimitivo;




        return true;
    }
}
