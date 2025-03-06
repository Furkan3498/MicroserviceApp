package com.company.product.RequestDto;

import com.company.product.model.constants.ApplicationConstants;
import jakarta.validation.constraints.NotNull;

public class ReduceQuantityRequest{
    @NotNull(message = ApplicationConstants.PRODUCT_ID_IS_REQUIRED)
    private Long productId;
    @NotNull(message = ApplicationConstants.QUANTITIY_IS_REQUIRED)
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
