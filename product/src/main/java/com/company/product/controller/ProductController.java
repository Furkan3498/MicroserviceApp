package com.company.product.controller;


import com.company.product.RequestDto.CreateProductRequest;
import com.company.product.RequestDto.ReduceQuantityRequest;
import com.company.product.responseDto.ProductResponse;
import com.company.product.service.abstraction.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
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


    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  reduceQuantity(@RequestBody @Valid ReduceQuantityRequest reduceQuantityRequest){
        productService.reduceQuantity(reduceQuantityRequest);
    }




}
