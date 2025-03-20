package com.company.orders.client;


import com.company.orders.OrderRequest.client.CreatePaymentRequest;
import com.company.orders.OrderResponse.client.PaymentResponse;
import com.company.orders.client.decoder.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "payment",
        url = "http://localhost:8082/v1/payments",
        configuration = CustomErrorDecoder.class
)
public interface PaymentClient {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //responseEntity yap
     void  pay(@RequestBody CreatePaymentRequest createPaymentRequest);



    @GetMapping("/order/{orderId}")
     PaymentResponse getPaymentByOrderId  (@PathVariable Long orderId);
}
