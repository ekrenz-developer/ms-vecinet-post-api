package com.vecinet.post.infrastructure.persistence.mongo.mapper;

import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.infrastructure.persistence.mongo.model.PostModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "location", ignore = true)
    @Mapping(source = "latitude", target = "latitude")
    @Mapping(source = "longitude", target = "longitude")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "dateToLong")
    @Mapping(source = "updatedAt", target = "updatedAt", qualifiedByName = "dateToLong")
    @Mapping(source = "deletedAt", target = "deletedAt", qualifiedByName = "dateToLong")
    PostModel toPersistence(PostEntity postEntity);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "longToDate")
    @Mapping(target = "updatedAt", source = "updatedAt", qualifiedByName = "longToDate")
    @Mapping(target = "deletedAt", source = "deletedAt", qualifiedByName = "longToDate")
    PostEntity toDomain(PostModel postModel);

    @Named("dateToLong")
    default Long dateToLong(Date date) {
        return date != null ? date.getTime() : null;
    }

    @Named("longToDate")
    default Date longToDate(Long timestamp) {
        return timestamp != null ? new Date(timestamp) : null;
    }
}
