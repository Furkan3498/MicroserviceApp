package com.company.product.service.abstraction;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.RequestDto.ReduceQuantityRequest;
import com.company.product.responseDto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    void createProduct(CreateProductRequest createProductRequest);
    ProductResponse getProductById(Long id);

    void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest);

}
