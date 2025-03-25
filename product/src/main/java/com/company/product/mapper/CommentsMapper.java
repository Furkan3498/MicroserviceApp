package com.company.product.mapper;

import com.company.product.entity.CommentsEntity;
import com.company.product.responseDto.CommentsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentsMapper {
    CommentsMapper INSTANCE = Mappers.getMapper(CommentsMapper.class);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "user.id", target = "userId")
    CommentsDTO toDTO(CommentsEntity review);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "userId", target = "user.id")
    CommentsEntity toEntity(CommentsDTO reviewDTO);
}