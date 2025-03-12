package com.company.product.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "comments")

public class CommentEntity {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "id", nullable = false)
    private ProductEntity product;




    private   String title;
    @Lob
         @Column(columnDefinition="text")
    private  String text;

    private LocalDateTime createDate;




    public CommentEntity() {
    }

    public CommentEntity(Long id, ProductEntity product, String title, String text, LocalDateTime createDate) {
        this.id = id;
        this.product = product;
        this.title = title;
        this.text = text;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return product;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.product = productEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "commentEntity{" +
                "id=" + id +
                ", productEntity=" + product +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
