package com.company.product.controller;


import com.company.product.responseDto.CommentsDTO;

import com.company.product.service.CommentsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private final CommentsServiceImpl reviewService;

    public CommentsController(CommentsServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<CommentsDTO> addReview(

            @RequestParam Long productId,
            @RequestBody CommentsDTO reviewDTO) {

        CommentsDTO createdReview = reviewService.createReview( productId, reviewDTO);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<CommentsDTO>> getReviews(@PathVariable Long productId) {
        List<CommentsDTO> reviews = reviewService.getReviewsByProduct(productId);
        return ResponseEntity.ok(reviews);
    }


}
