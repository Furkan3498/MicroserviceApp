package com.company.product.responseDto;

import java.time.LocalDateTime;

public class CommentsDTO {
    private Long id;
    private String comment;
    private LocalDateTime createdAt;
    private int rating;
    private Long productId;

    public CommentsDTO(Long id, String comment, LocalDateTime createdAt, int rating, Long productId) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.rating = rating;
        this.productId = productId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
}
