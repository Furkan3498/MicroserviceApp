package com.company.orders.controller;


import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderResponse.OrderCreateResponse;
import com.company.orders.Service.abstraction.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderCreateRequest orderCreateRequest){
         orderService.createOrder(orderCreateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCreateResponse> getOrderById(@PathVariable Long id){
        return  ResponseEntity.ok(orderService.getOrderById(id));
    }
}
