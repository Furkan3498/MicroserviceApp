package com.company.orders.OrderRequest.client;

import com.company.orders.entity.enums.PaymentType;

import java.math.BigDecimal;

public class CreatePaymentRequest {


    private Long orderId;
    private PaymentType paymentType;
    private BigDecimal amount;
    private String referenceNumber;

    public CreatePaymentRequest() {
    }

    public CreatePaymentRequest(Long orderId, PaymentType paymentType, BigDecimal amount, String referenceNumber) {
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

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
