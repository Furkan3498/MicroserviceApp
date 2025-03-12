package com.company.product.RequestDto;

public class CommentCreateRequest {


    private Long id;
    private Long productId;

    private String text;

    public CommentCreateRequest() {
    }

    public CommentCreateRequest(Long id, Long productId, String text) {
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

    @Override
    public String toString() {
        return "CommentCreateRequest{" +
                "id=" + id +
                ", productId=" + productId +
                ", text='" + text + '\'' +
                '}';
    }
}
