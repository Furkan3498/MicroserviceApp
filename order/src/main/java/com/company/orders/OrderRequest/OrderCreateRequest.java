package com.company.orders.OrderRequest;

import com.company.orders.entity.enums.PaymentType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class OrderCreateRequest {

        @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;
    @NotNull
    private BigDecimal amount;
    private PaymentType paymentType;


    public OrderCreateRequest() {
    }

    public OrderCreateRequest(Long productId, Integer quantity, BigDecimal amount, PaymentType paymentType) {
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "OrderCreateRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", paymentType=" + paymentType +
                '}';
    }
}
