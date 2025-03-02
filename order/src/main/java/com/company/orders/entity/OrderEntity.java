package com.company.orders.entity;


import com.company.orders.entity.enums.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")

public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private  Integer quantitiy;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public OrderEntity() {
    }

    public OrderEntity(Long id, Long productId, Integer quantitiy, OrderStatus status, BigDecimal amount, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.quantitiy = quantitiy;
        this.status = status;
        this.amount = amount;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantitiy=" + quantitiy +
                ", status=" + status +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}
