package com.company.orders.OrderRequest;

import com.company.orders.entity.enums.PaymentType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

import static com.company.orders.entity.constants.ApplicationConstants.*;

public class OrderCreateRequest {

        @NotNull(message = PRODUCT_ID_IS_REQUIRED)
    private Long productId;
    @NotNull(message = NAME_IS_Quantity)
    private Integer quantity;

    private PaymentType paymentType;


    public OrderCreateRequest() {
    }

    public OrderCreateRequest(Long productId, Integer quantity,  PaymentType paymentType) {
        this.productId = productId;
        this.quantity = quantity;

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
                ", paymentType=" + paymentType +
                '}';
    }
}
