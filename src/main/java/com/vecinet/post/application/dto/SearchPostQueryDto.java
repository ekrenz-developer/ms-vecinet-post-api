package com.vecinet.post.application.dto;

import com.vecinet.post.domain.valueobject.PostSearchCriteriaValueObject;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter()
@SuperBuilder()
public class SearchPostQueryDto extends PostSearchCriteriaValueObject {
}
