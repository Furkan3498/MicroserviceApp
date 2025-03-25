package com.company.product.repository;

import com.company.product.entity.Review;
import com.company.product.responseDto.ReviewDTO;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {



        List<Review> findByProductId(Long productId);
    @Query("SELECT new com.company.product.responseDto.ReviewDTO(r.id, r.comment, r.createdAt, r.rating, r.product.id) FROM Review r WHERE r.product.id = :productId")
    List<ReviewDTO> getReviewsByProduct(@Param("productId") Long productId);





    }

