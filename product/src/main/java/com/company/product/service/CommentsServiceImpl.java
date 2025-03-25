package com.company.product.service;


import com.company.product.entity.ProductEntity;
import com.company.product.entity.CommentsEntity;
import com.company.product.repository.ProductRepository;
import com.company.product.repository.CommentsRepository;
import com.company.product.responseDto.CommentsDTO;
import com.company.product.service.concrete.ProductServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl {
    private final CommentsDomainService reviewDomainService;
    private final ProductRepository productRepository;
    private final CommentsRepository reviewRepository;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    public CommentsServiceImpl(CommentsDomainService reviewDomainService, ProductRepository productRepository, CommentsRepository reviewRepository) {
        this.reviewDomainService = reviewDomainService;
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    public CommentsDTO createReview(Long productId, CommentsDTO reviewDTO) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId)); // Hata fırlatır
        CommentsEntity review = new CommentsEntity();
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setProduct(product);  // Product setleniyor mu? Kontrol et.
        review.setCreatedAt(LocalDateTime.now());
        reviewRepository.save(review);
        return new CommentsDTO(review.getId(), review.getComment(),review.getCreatedAt(), review.getRating(), review.getProduct().getId());
    }


    public List<CommentsDTO> getReviewsByProduct(Long productId) {
        return reviewRepository.getReviewsByProduct(productId);
    }

    public List<CommentsDTO> convertToReviewDTOList(CommentsDTO... reviews) {
        List<CommentsDTO> reviewDTOList = new ArrayList<>();
        for (CommentsDTO review : reviews) {
            reviewDTOList.add(review);  // ReviewDTO'yu listeye ekliyoruz
        }
        return reviewDTOList;
    }


    }

