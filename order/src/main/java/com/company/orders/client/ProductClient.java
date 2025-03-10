package com.company.orders.client;

import com.company.orders.client.decoder.CustomErrorDecoder;
import com.company.orders.entity.client.ReduceQuantityRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "product",
        url = "https://localhost:8080",
        configuration = CustomErrorDecoder.class)


        public interface ProductClient {
     @PostMapping("/reduce-quantity")
        void reduceQuantity(@RequestBody ReduceQuantityRequest reduceQuantityRequest);
    }
