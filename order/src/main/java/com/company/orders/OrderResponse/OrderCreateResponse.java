package com.company.orders.OrderResponse;

import com.company.orders.OrderResponse.client.ProductResponse;
import com.company.orders.entity.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDateTime;



public class OrderCreateResponse {


    private Long id;
    private Long productId;
    private  Integer quantitiy;

    private OrderStatus status;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    private ProductResponse product;

    public OrderCreateResponse() {
    }

    public OrderCreateResponse(Long id, Long productId, Integer quantitiy, OrderStatus status, BigDecimal amount, LocalDateTime createdAt, ProductResponse product) {
        this.id = id;
        this.productId = productId;
        this.quantitiy = quantitiy;
        this.status = status;
        this.amount = amount;
        this.createdAt = createdAt;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(Integer quantitiy) {
        this.quantitiy = quantitiy;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderCreateResponse{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantitiy=" + quantitiy +
                ", status=" + status +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", product=" + product +
                '}';
    }
}
