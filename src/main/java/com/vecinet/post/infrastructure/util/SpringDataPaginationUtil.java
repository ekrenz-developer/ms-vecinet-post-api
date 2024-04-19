package com.vecinet.post.infrastructure.util;

import com.vecinet.post.domain.valueobject.PageableValueObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpringDataPaginationUtil {
    public Pageable toPageable(PageableValueObject pageableValueObject) {
        Sort.Direction direction = Sort.Direction.valueOf(pageableValueObject.getSortDirection().name());
        Sort sort = Sort.by(direction, pageableValueObject.getSortBy());
        return PageRequest.of(pageableValueObject.getPageNumber(), pageableValueObject.getPageSize(), sort);
    }
}
