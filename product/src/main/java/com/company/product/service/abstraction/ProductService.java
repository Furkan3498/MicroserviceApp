package com.company.product.service.abstraction;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.responseDto.ProductResponse;
import org.springframework.stereotype.Service;


public interface ProductService {
    void createProduct(CreateProductRequest createProductRequest);
    ProductResponse getProductById(Long id);

}
