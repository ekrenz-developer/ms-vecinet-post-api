package com.vecinet.post.infrastructure.rest.mapper;

import com.vecinet.post.application.dto.SearchPostQueryDto;
import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.valueobject.LocationSearchValueObject;
import com.vecinet.post.domain.valueobject.PageValueObject;
import com.vecinet.post.domain.valueobject.PageableValueObject;
import com.vecinet.post.infrastructure.rest.dto.PageResponseDto;
import com.vecinet.post.infrastructure.rest.dto.PostBodyDto;
import com.vecinet.post.infrastructure.rest.dto.PostResponseDto;
import com.vecinet.post.infrastructure.rest.dto.PostSearchQueryParamDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", implementationName = "RestPostMapper")
public interface PostMapper {
    default PostEntity toEntity(PostBodyDto postDto) {
        return PostEntity.builder()
               .username(postDto.getUsername())
               .latitude(postDto.getLatitude())
               .longitude(postDto.getLongitude())
               .content(postDto.getContent())
               .build();
    }

    @Named("toResponse")
    default PostResponseDto toResponse(PostEntity postEntity) {
        return PostResponseDto.builder()
               .id(postEntity.getId())
               .latitude(postEntity.getLatitude())
               .longitude(postEntity.getLongitude())
               .content(postEntity.getContent())
               .username(postEntity.getUsername())
               .createdAt(postEntity.getCreatedAt())
               .updatedAt(postEntity.getUpdatedAt())
               .deletedAt(postEntity.getDeletedAt())
               .build();
    }

    default SearchPostQueryDto toSearchPostQueryDto(PostSearchQueryParamDto postSearchQueryParamDto) {
        LocationSearchValueObject locationSearch = LocationSearchValueObject.builder()
                .username(postSearchQueryParamDto.getUsername())
                .latitude(postSearchQueryParamDto.getLatitude())
                .longitude(postSearchQueryParamDto.getLongitude())
//                .distanceInKm(postSearchQueryParamDto.getDistanceInKm())
                .build();


        Integer page = postSearchQueryParamDto.getPage();
        Integer size = postSearchQueryParamDto.getSize();

        PageableValueObject.PageableValueObjectBuilder builder = PageableValueObject.builder();
        if ( page != null ) builder.pageNumber(page -1);
        if ( size != null ) builder.pageSize(size);
        PageableValueObject pageable = builder.build();


        return SearchPostQueryDto.builder()
                .pageable(pageable)
                .locationSearch(locationSearch)
                .build();
    }

    @Named("toResponseList")
    @IterableMapping(qualifiedByName = "toResponse")
    List<PostResponseDto> toResponseList(List<PostEntity> postEntityList);

    default PageResponseDto<PostResponseDto> toPageResponseDto(PageValueObject<PostEntity> pageValueObject) {
        List<PostResponseDto> content = toResponseList(pageValueObject.getContent());
        PageResponseDto.PaginationMetadata metadata = PageResponseDto.PaginationMetadata.builder()
                .pageNumber(pageValueObject.getPageNumber() + 1)
                .pageSize(pageValueObject.getPageSize())
                .totalElements(pageValueObject.getTotalElements())
                .hasPreviousPage(pageValueObject.getHasPreviousPage())
                .hasNextPage(pageValueObject.getHasNextPage())
                .build();
        return PageResponseDto.<PostResponseDto>builder()
               .content(content)
               .metadata(metadata)
               .build();
    }
}
