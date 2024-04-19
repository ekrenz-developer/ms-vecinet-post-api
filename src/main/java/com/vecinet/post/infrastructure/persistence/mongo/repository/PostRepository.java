package com.vecinet.post.infrastructure.persistence.mongo.repository;

import com.vecinet.post.domain.entity.PostEntity;
import com.vecinet.post.domain.port.PostRespositoryPort;
import com.vecinet.post.domain.valueobject.PageValueObject;
import com.vecinet.post.domain.valueobject.PostSearchCriteriaValueObject;
import com.vecinet.post.infrastructure.persistence.mongo.mapper.PostMapper;
import com.vecinet.post.infrastructure.persistence.mongo.model.PostModel;
import com.vecinet.post.infrastructure.util.SpringDataPaginationUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository implements PostRespositoryPort {
    private static final String LOCATION_KEY = "location";

    private final MongoTemplate mongoTemplate;
    private final PostMapper postMapper;
    private final SpringDataPaginationUtil springDataPaginationUtil;

    public PostRepository(MongoTemplate mongoTemplate, PostMapper postMapper, SpringDataPaginationUtil springDataPaginationUtil) {
        this.mongoTemplate = mongoTemplate;
        this.postMapper = postMapper;
        this.springDataPaginationUtil = springDataPaginationUtil;
    }

    @Override
    public PageValueObject<PostEntity> search(PostSearchCriteriaValueObject criteria) {
        Point location = new Point(criteria.getLocationSearch().getLongitude(), criteria.getLocationSearch().getLatitude());
        Distance distance = new Distance(criteria.getLocationSearch().getDistanceInKm(), Metrics.KILOMETERS);
        Query query = new Query(Criteria.where(LOCATION_KEY).nearSphere(location).maxDistance(distance.getNormalizedValue()));

        // Ajusta la consulta para traer un elemento más del necesario
        Pageable pageable = this.springDataPaginationUtil.toPageable(criteria.getPageable());
        query.with(pageable).limit(pageable.getPageSize() + 1);
        List<PostModel> postModelList = this.mongoTemplate.find(query, PostModel.class);

        // Verificar si hay más elementos de los que se pueden mostrar en una página
        boolean hasNext = postModelList.size() > pageable.getPageSize();

        // Si hay más elementos, remover el extra que se utilizó solo para la comprobación
        List<PostModel> filteredPostModelList = hasNext ? postModelList.subList(0, pageable.getPageSize()) : postModelList;
        List<PostEntity> postEntityList = filteredPostModelList.stream().map(this.postMapper::toDomain).toList();

        // Crear la página sin hacer un count real
        return PageValueObject.<PostEntity>builder()
                .content(postEntityList)
                .pageNumber(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .totalElements(postEntityList.size())
                .hasPreviousPage(pageable.getPageNumber() > 0)
                .hasNextPage(hasNext)
                .build();
    }
}
