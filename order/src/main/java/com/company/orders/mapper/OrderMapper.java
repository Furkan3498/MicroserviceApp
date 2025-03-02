package com.company.orders.mapper;

import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.entity.OrderEntity;
import com.company.orders.entity.enums.OrderStatus;

import java.time.LocalDateTime;

public enum OrderMapper {

    ORDER_MAPPER;


    public OrderEntity mapToEntity(OrderCreateRequest orderCreateRequest) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setProductId(orderCreateRequest.getProductId());
        orderEntity.setAmount(orderCreateRequest.getAmount());
        orderEntity.setQuantitiy(orderCreateRequest.getQuantity());
        orderEntity.setStatus(OrderStatus.PENDING);
        orderEntity.setCreatedAt(LocalDateTime.now());
        return  orderEntity;
    }
 }
