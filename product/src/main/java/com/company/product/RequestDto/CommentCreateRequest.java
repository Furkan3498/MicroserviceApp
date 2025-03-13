package com.company.product.RequestDto;

public class CommentCreateRequest {


    private Long productId;

    private String text;

    public CommentCreateRequest() {
    }

    public CommentCreateRequest( Long productId, String text) {

        this.productId = productId;
        this.text = text;
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

                ", productId=" + productId +
                ", text='" + text + '\'' +
                '}';
    }
}
