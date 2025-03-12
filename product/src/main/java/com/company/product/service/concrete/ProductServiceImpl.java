package com.company.product.service.concrete;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.RequestDto.ReduceQuantityRequest;
import com.company.product.entity.ProductEntity;
import com.company.product.entity.enums.ErrorMessage;
import com.company.product.exception.InsufficientQuantityException;
import com.company.product.mapper.ProductMapper;
import com.company.product.exception.NotFoundException;
import com.company.product.repository.ProductRepository;
import com.company.product.responseDto.ProductResponse;
import com.company.product.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.company.product.entity.enums.ErrorMessage.INSUFFICIENT_QUANTITY;
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
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            ProductResponse productResponse = ProductMapper.PRODUCT_MAPPER.buildProductResponse(product); //Aslında  ProductResponse productResponse gerek yok
            return productResponse;

        } else {
            String errorMessage = String.format(PRODUCT_NOT_FOUND.getMessage(), id);
            throw new NotFoundException(errorMessage);
        }

    }
    protected ProductEntity getProductByIdForComment(Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
          return product;

        } else {
            String errorMessage = String.format(PRODUCT_NOT_FOUND.getMessage(), id);
            throw new NotFoundException(errorMessage);
        }

    }

    @Override
    public void reduceQuantity(ReduceQuantityRequest reduceQuantityRequest) {
        var productEntity = productRepository.findById(reduceQuantityRequest.getProductId())
                .orElseThrow(() -> new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(),
                        reduceQuantityRequest.getProductId()
                )));


        if (productEntity.getQuantity() < reduceQuantityRequest.getQuantity())  {

            throw new InsufficientQuantityException(format(INSUFFICIENT_QUANTITY.getMessage(),
                    reduceQuantityRequest.getProductId()    ));
        }



    productEntity.setQuantity(productEntity.getQuantity() -reduceQuantityRequest.getQuantity());
        productRepository.save(productEntity);
    }



    private ProductResponse fetchProduct (Long id){
        return productRepository.findById(id)
                .map(ProductMapper.PRODUCT_MAPPER::buildProductResponse)
                .orElseThrow(()-> new NotFoundException(format(PRODUCT_NOT_FOUND.getMessage(),
                        id
                )));
    }
    }



