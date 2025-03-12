package com.company.orders.mapper;

import com.company.orders.OrderRequest.OrderCreateRequest;
import com.company.orders.OrderRequest.client.CreatePaymentRequest;
import com.company.orders.entity.OrderEntity;

import java.math.BigDecimal;
import java.util.UUID;

public enum PaymentMapper {

    PAYMENT_MAPPER;

    public CreatePaymentRequest createPaymentRequest(
            OrderEntity orderEntity,
            OrderCreateRequest orderCreateRequest,
            BigDecimal totalAmount

                                        ){

        CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
        createPaymentRequest.setOrderId(orderEntity.getId());
        createPaymentRequest.setPaymentType(orderCreateRequest.getPaymentType());
        createPaymentRequest.setAmount(totalAmount);
        createPaymentRequest.setReferenceNumber(UUID.randomUUID().toString());

        return  createPaymentRequest;
    }
}
