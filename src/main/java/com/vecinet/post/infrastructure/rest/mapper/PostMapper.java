package com.vecinet.post.infrastructure.rest.mapper;

import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.infrastructure.rest.dto.PostBodyDto;
import com.vecinet.post.infrastructure.rest.dto.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
}
