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
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", implementationName = "RestPostMapper")
public interface PostMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "username", target = "username")
    PostEntity toEntity(PostBodyDto postDto);

    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "username", target = "username")
    PostResponseDto toResponse(PostEntity postEntity);

    default SearchPostQueryDto toSearchPostQueryDto(PostSearchQueryParamDto postSearchQueryParamDto) {
        LocationSearchValueObject locationSearch = LocationSearchValueObject.builder()
                .username(postSearchQueryParamDto.getUsername())
                .latitude(postSearchQueryParamDto.getLatitude())
                .longitude(postSearchQueryParamDto.getLongitude())
                .distanceInKm(postSearchQueryParamDto.getDistanceInKm())
                .build();

        PageableValueObject pageable = PageableValueObject.builder()
                .pageNumber(postSearchQueryParamDto.getPage() - 1)
                .pageSize(postSearchQueryParamDto.getSize())
                .build();

        return SearchPostQueryDto.builder()
                .pageable(pageable)
                .locationSearch(locationSearch)
                .build();
    }

    List<PostResponseDto> toResponseList(List<PostEntity> postEntityList);

    @Mapping(source = "content", target = "content", qualifiedByName = "toResponseList")
    @Mapping(source = "pageNumber", target = "metadata.pageNumber")
    @Mapping(source = "pageSize", target = "metadata.pageSize")
    @Mapping(source = "totalElements", target = "metadata.totalElements")
    @Mapping(source = "hasPreviousPage", target = "metadata.hasPreviousPage")
    @Mapping(source = "hasNextPage", target = "metadata.hasNextPage")
    PageResponseDto<PostResponseDto> toPageResponseDto(PageValueObject<PostEntity> pageValueObject);
}
