package com.vecinet.post.infrastructure.rest.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class PostSearchQueryParamDto extends BaseQueryParamDto {
    private  String username;
    private  Double latitude;
    private  Double longitude;
    private Integer distanceInKm;

     public PostSearchQueryParamDto(Integer page, Integer size, String username, Double latitude, Double longitude, Integer distanceInKm) {
          super(page, size);
          this.username = username;
          this.latitude = latitude;
          this.longitude = longitude;
          this.distanceInKm = distanceInKm;
     }

}
