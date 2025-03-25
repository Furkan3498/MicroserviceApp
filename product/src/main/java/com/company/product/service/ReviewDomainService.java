package com.company.product.service;

import com.company.product.entity.ProductEntity;
import com.company.product.entity.Review;
import com.company.product.exception.NotFoundException;
import com.company.product.repository.ProductRepository;
import com.company.product.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewDomainService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewDomainService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<Review> findByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review saveReview( Long productId, Review review) { // ✅ Metodu güncelledik!

        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Ürün bulunamadı: " + productId));

        review.setProduct(product);

        return reviewRepository.save(review);
    }
}