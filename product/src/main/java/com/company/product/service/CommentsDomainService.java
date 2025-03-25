package com.company.product.service;

import com.company.product.entity.ProductEntity;
import com.company.product.entity.CommentsEntity;
import com.company.product.exception.NotFoundException;
import com.company.product.repository.ProductRepository;
import com.company.product.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsDomainService {
    private final CommentsRepository reviewRepository;
    private final ProductRepository productRepository;

    public CommentsDomainService(CommentsRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<CommentsEntity> findByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public CommentsEntity saveReview(Long productId, CommentsEntity review) { // ✅ Metodu güncelledik!

        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Ürün bulunamadı: " + productId));

        review.setProduct(product);

        return reviewRepository.save(review);
    }
}