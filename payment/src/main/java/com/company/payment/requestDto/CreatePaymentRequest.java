package com.company.payment.requestDto;

import com.company.payment.entity.enums.PaymentType;

import java.math.BigDecimal;
import java.util.UUID;

public class CreatePaymentRequest {
    private Long orderId;
    private PaymentType paymentType;
    private BigDecimal amount;
    private UUID referenceNumber;

    public CreatePaymentRequest() {
    }

    public CreatePaymentRequest(Long orderId, PaymentType paymentType, BigDecimal amount, UUID referenceNumber) {
        this.orderId = orderId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UUID getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(UUID referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
