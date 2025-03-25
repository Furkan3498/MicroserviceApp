package com.company.product.responseDto;


import java.math.BigDecimal;
import java.util.List;


public class ProductResponse {


    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;


  private List<CommentsDTO> reviewDTOList;

    public List<CommentsDTO> getReviewDTOList() {
        return reviewDTOList;
    }

    public void setReviewDTOList(List<CommentsDTO> reviewDTOList) {
        this.reviewDTOList = reviewDTOList;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

