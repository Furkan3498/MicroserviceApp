package com.company.product.service.concrete;

import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.RequestDto.ReduceQuantityRequest;
import com.company.product.entity.CommentEntity;
import com.company.product.entity.ProductEntity;
import com.company.product.exception.InsufficientQuantityException;
import com.company.product.mapper.ProductMapper;
import com.company.product.exception.NotFoundException;
import com.company.product.repository.CommentRepository;
import com.company.product.repository.ProductRepository;
import com.company.product.responseDto.CommentResponse;
import com.company.product.responseDto.ProductResponse;
import com.company.product.service.abstraction.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.product.entity.enums.ErrorMessage.INSUFFICIENT_QUANTITY;
import static com.company.product.entity.enums.ErrorMessage.PRODUCT_NOT_FOUND;
import static com.company.product.mapper.ProductMapper.PRODUCT_MAPPER;
import static java.lang.String.*;

@Service
@Slf4j

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    public ProductServiceImpl(ProductRepository productRepository,  CommentRepository commentRepository,@Lazy CommentService commentService) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @Override
    public void createProduct(CreateProductRequest createProductRequest) {

        productRepository.save(PRODUCT_MAPPER.buildProductEntity(createProductRequest));

    }

    @Override
    public ProductResponse getProductById(Long id) {


        return productRepository.findById(id)
                .map(PRODUCT_MAPPER::buildProductResponse)
                .orElseThrow(() -> new NotFoundException(
                        format(PRODUCT_NOT_FOUND.getMessage(),
                                id)
                ));



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



    public  List<ProductResponse> getProductAll() throws Exception{
        List<ProductEntity> productList = getProductList();
        return PRODUCT_MAPPER.mapToProductResponseDtoList(productList);
    }
    private  List<ProductEntity> getProductList(){
        return (List<ProductEntity>) productRepository.findAll();
    }



    public List<ProductResponse> getProductByPriceRange(double minPrice, double maxPrice) {

        List<ProductEntity> productList = getProductList();


        return productList.stream()
                .filter(product -> product.getPrice() != null
                        && product.getPrice().compareTo(BigDecimal.valueOf(minPrice)) >= 0
                        && product.getPrice().compareTo(BigDecimal.valueOf(maxPrice)) <= 0)
                .map(PRODUCT_MAPPER::buildProductResponse)
                .sorted(Comparator.comparing(ProductResponse::getPrice).reversed())
                .collect(Collectors.toList());
    }

    }



