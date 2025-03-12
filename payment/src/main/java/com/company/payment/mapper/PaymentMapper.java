package com.company.payment.mapper;

import com.company.payment.entity.PaymentEntity;
import com.company.payment.entity.enums.PaymentStatus;
import com.company.payment.requestDto.CreatePaymentRequest;

import java.time.LocalDateTime;
import java.util.UUID;

public enum PaymentMapper {

    PAYMENT_MAPPER;

    public PaymentEntity mapToEntity(CreatePaymentRequest createPaymentRequest){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setReferenceNumber(UUID.randomUUID().toString());
        paymentEntity.setOrderId(createPaymentRequest.getOrderId());
        paymentEntity.setAmount(createPaymentRequest.getAmount());
        paymentEntity.setPaymentType(createPaymentRequest.getPaymentType());
        paymentEntity.setPaymentStatus(PaymentStatus.SUCCESS);
        paymentEntity.setLocalDateTime(LocalDateTime.now());
        return paymentEntity;
    }
}
