package com.company.product.mapper;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.entity.ProductEntity;
import com.company.product.responseDto.ProductResponse;

import java.util.function.Function;

public enum ProductMapper {

    PRODUCT_MAPPER;



    public ProductEntity buildProductEntity(CreateProductRequest createProductRequest){

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(createProductRequest.getName());
        productEntity.setDescription(createProductRequest.getDescription());
        productEntity.setQuantity(createProductRequest.getQuantity());
        productEntity.setPrice(createProductRequest.getPrice());

        return productEntity;


    }

    public ProductResponse buildProductResponse(ProductEntity productEntity){

        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(productEntity.getName());
        productResponse.setId(productEntity.getId());
        productResponse.setPrice(productEntity.getPrice());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setQuantity(productEntity.getQuantity());
        return productResponse;



    }
}
