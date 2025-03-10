package com.company.product.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product", url = "https://localhost:8080")
public interface ProductFeignClient {
}
