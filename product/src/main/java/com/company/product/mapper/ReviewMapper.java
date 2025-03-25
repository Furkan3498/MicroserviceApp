package com.company.product.mapper;

import com.company.product.entity.Review;
import com.company.product.responseDto.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "user.id", target = "userId")
    ReviewDTO toDTO(Review review);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "userId", target = "user.id")
    Review toEntity(ReviewDTO reviewDTO);
}