package com.company.product.service;


import com.company.product.entity.ProductEntity;
import com.company.product.entity.Review;
import com.company.product.mapper.ReviewMapper;
import com.company.product.repository.ProductRepository;
import com.company.product.repository.ReviewRepository;
import com.company.product.responseDto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl {
    private final ReviewDomainService reviewDomainService;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewDomainService reviewDomainService, ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.reviewDomainService = reviewDomainService;
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    public ReviewDTO createReview(Long productId, ReviewDTO reviewDTO) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId)); // Hata fırlatır
        Review review = new Review();
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setProduct(product);  // Product setleniyor mu? Kontrol et.
        review.setCreatedAt(LocalDateTime.now());
        reviewRepository.save(review);
        return new ReviewDTO(review.getId(), review.getComment(),review.getCreatedAt(), review.getRating(), review.getProduct().getId());
    }


    public List<ReviewDTO> getReviewsByProduct(Long productId) {
        return reviewRepository.getReviewsByProduct(productId);
    }
}
