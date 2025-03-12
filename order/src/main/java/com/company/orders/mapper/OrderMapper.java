package com.company.orders.mapper;

import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderResponse.OrderCreateResponse;
import com.company.orders.OrderResponse.client.ProductResponse;
import com.company.orders.entity.OrderEntity;
import com.company.orders.entity.enums.OrderStatus;

import java.time.LocalDateTime;

public enum OrderMapper {

    ORDER_MAPPER;


    public OrderEntity mapToEntity(OrderCreateRequest orderCreateRequest) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProductId(orderCreateRequest.getProductId());
        orderEntity.setQuantitiy(orderCreateRequest.getQuantity());
        orderEntity.setStatus(OrderStatus.PENDING);
        orderEntity.setCreatedAt(LocalDateTime.now());
        return  orderEntity;
    }

    public OrderCreateResponse mapToDto (OrderEntity orderEntity, ProductResponse productResponse){
        OrderCreateResponse orderCreateResponse = new OrderCreateResponse();
        orderCreateResponse.setId(orderEntity.getId());
        orderCreateResponse.setProductId(orderEntity.getProductId());
        orderCreateResponse.setAmount(orderEntity.getAmount());
        orderCreateResponse.setQuantitiy(orderEntity.getQuantitiy());
        orderCreateResponse.setStatus(orderEntity.getStatus());
        orderCreateResponse.setCreatedAt(orderEntity.getCreatedAt());
        orderCreateResponse.setProduct(productResponse);
        return orderCreateResponse;
    }
 }
