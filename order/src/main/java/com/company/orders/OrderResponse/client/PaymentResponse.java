package com.company.orders.OrderResponse.client;

import com.company.orders.entity.enums.PaymentType;

import java.time.LocalDateTime;

public class PaymentResponse {
    private Long id;

    private PaymentStatus paymentStatus;
    private LocalDateTime localDateTime;
    private PaymentType paymentType;

    public PaymentResponse(Long id, PaymentStatus paymentStatus, LocalDateTime localDateTime, PaymentType paymentType) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.localDateTime = localDateTime;
        this.paymentType = paymentType;
    }

    public PaymentResponse() {
    }

    public PaymentResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
