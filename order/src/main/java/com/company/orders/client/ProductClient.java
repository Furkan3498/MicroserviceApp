package com.company.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "product", url = "https://localhost:8080")
public interface ProductClient {




        @PostMapping("/reduce-quantity")
        void reduceQuantity(@RequestBody ReduceQuantityRequest reduceQuantityRequest);
    }
