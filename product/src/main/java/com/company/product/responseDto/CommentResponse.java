package com.company.product.responseDto;

import com.company.product.entity.ProductEntity;
import com.company.product.entity.CommentEntity;

public class CommentResponse {


    private Long id;
    private ProductEntity name;
    private String text;

    public CommentResponse(CommentEntity comment) {
    }

    public CommentResponse() {
    }

    public CommentResponse(Long id, ProductEntity name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getName() {
        return name;
    }

    public void setName(ProductEntity name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
