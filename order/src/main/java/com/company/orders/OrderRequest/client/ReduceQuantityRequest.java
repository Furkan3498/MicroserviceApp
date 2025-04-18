package com.company.orders.OrderRequest.client;

public class ReduceQuantityRequest {

    private Long productId;
    private Integer quantity;

    public ReduceQuantityRequest() {
    }

    public ReduceQuantityRequest(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "ReduceQuantityRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
