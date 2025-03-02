package com.company.orders.Service.abstraction;

import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderResponse.OrderCreateResponse;

public interface OrderService {

    void createOrder(OrderCreateRequest orderCreateRequest);

    OrderCreateResponse getOrderById(Long id);
}
