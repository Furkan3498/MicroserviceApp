package com.company.product.RequestDto;


import com.company.product.model.constants.ApplicationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.company.product.model.constants.ApplicationConstants.*;


public class CreateProductRequest {
    @NotBlank(message = NAME_IS_REQUIRED)
    private String name;
    @NotBlank(message = ApplicationConstants.NAME_IS_Description)
    private String description;
    @NotNull(message = NAME_IS_Price)
    private BigDecimal price;
    @NotNull(message = NAME_IS_Quantity)
    private Integer quantity;

    public CreateProductRequest() {
    }

    public CreateProductRequest(String name, String description, BigDecimal price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
