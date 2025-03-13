package com.company.product.responseDto;

import com.company.product.entity.ProductEntity;
import com.company.product.entity.CommentEntity;

public class CommentResponse {


    private Long id;
    private Long productId;
    private String text;

    public CommentResponse(CommentEntity comment) {
    }

    public CommentResponse() {
    }

    public CommentResponse(Long id, Long productId, String text) {
        this.id = id;
        this.productId = productId;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
