package com.company.payment.entity;


import com.company.payment.entity.enums.PaymentStatus;
import com.company.payment.entity.enums.PaymentType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;

    private String referenceNumber;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private BigDecimal amount;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, Long orderId, String referenceNumber, PaymentType paymentType, PaymentStatus paymentStatus, BigDecimal amount, LocalDateTime localDateTime) {
        this.id = id;
        this.orderId = orderId;
        this.referenceNumber = referenceNumber;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", referenceNumber=" + referenceNumber +
                ", paymentType=" + paymentType +
                ", paymentStatus=" + paymentStatus +
                ", amount=" + amount +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
