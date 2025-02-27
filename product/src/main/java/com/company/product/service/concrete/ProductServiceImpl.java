package com.company.product.service.concrete;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.entity.enums.ErrorMessage;
import com.company.product.mapper.ProductMapper;
import com.company.product.exception.NotFoundException;
import com.company.product.repository.ProductRepository;
import com.company.product.responseDto.ProductResponse;
import com.company.product.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.company.product.entity.enums.ErrorMessage.PRODUCT_NOT_FOUND;
import static java.lang.String.*;

@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(CreateProductRequest createProductRequest) {

        productRepository.save(ProductMapper.PRODUCT_MAPPER.buildProductEntity(createProductRequest));

    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper.PRODUCT_MAPPER::buildProductResponse)
                .orElseThrow(()-> new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(),
                        id
                )));
    }







































}
