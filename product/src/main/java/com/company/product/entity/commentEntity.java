package com.company.product.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comments")

public class commentEntity {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="products_id", nullable=false)
        private ProductEntity productEntity;



         String title;
    @Lob
         @Column(columnDefinition="text")
    private  String text;

    @Temporal(TemporalType.TIMESTAMP)
            private Date createDate;


    public commentEntity() {
    }

    public commentEntity(Long id, ProductEntity productEntity, String title, String text, Date createDate) {
        this.id = id;
        this.productEntity = productEntity;
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
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "commentEntity{" +
                "id=" + id +
                ", productEntity=" + productEntity +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
