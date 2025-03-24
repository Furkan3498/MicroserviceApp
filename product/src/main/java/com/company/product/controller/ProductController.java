package com.company.product.controller;


import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.RequestDto.ReduceQuantityRequest;
import com.company.product.responseDto.ProductResponse;
import com.company.product.service.abstraction.ProductService;
import com.company.product.service.concrete.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@Slf4j

public class ProductController {

    private final ProductService productService;
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl) {
        this.productService = productService;
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid CreateProductRequest createProductRequest){

        productService.createProduct(createProductRequest);
    }


    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    @PostMapping("/reduce-quantity")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  reduceQuantity(@RequestBody @Valid ReduceQuantityRequest reduceQuantityRequest){
        productService.reduceQuantity(reduceQuantityRequest);
    }


    @GetMapping("/productByPriceRange")
    public ResponseEntity<List<ProductResponse>> getProductByPriceRange(
            @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice") double maxPrice) {
        List<ProductResponse> productNamesByPriceRange = productServiceImpl.getProductByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(productNamesByPriceRange);
    }



}
