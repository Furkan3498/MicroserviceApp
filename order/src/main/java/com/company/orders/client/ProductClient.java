package com.company.orders.client;

import com.company.orders.OrderResponse.client.ProductResponse;
import com.company.orders.client.decoder.CustomErrorDecoder;
import com.company.orders.OrderRequest.client.ReduceQuantityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "product",
        url = "http://localhost:9999/v1/products",
        configuration = CustomErrorDecoder.class)
public interface ProductClient {
     @PostMapping("/reduce-quantity")
        void reduceQuantity(@RequestBody ReduceQuantityRequest reduceQuantityRequest);

    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable Long id);






    }
