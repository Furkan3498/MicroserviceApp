package com.company.product.controller;


import com.company.product.responseDto.ReviewDTO;

import com.company.product.service.ReviewServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<ReviewDTO> addReview(

            @RequestParam Long productId,
            @RequestBody ReviewDTO reviewDTO) {

        ReviewDTO createdReview = reviewService.createReview( productId, reviewDTO);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long productId) {
        List<ReviewDTO> reviews = reviewService.getReviewsByProduct(productId);
        return ResponseEntity.ok(reviews);
    }


}
