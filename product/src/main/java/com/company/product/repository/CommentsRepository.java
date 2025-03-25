package com.company.product.repository;

import com.company.product.entity.CommentsEntity;
import com.company.product.responseDto.CommentsDTO;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {



        List<CommentsEntity> findByProductId(Long productId);
    @Query("SELECT new com.company.product.responseDto.CommentsDTO(r.id, r.comment, r.createdAt, r.rating, r.product.id) FROM CommentsEntity r WHERE r.product.id = :productId")
    List<CommentsDTO> getReviewsByProduct(@Param("productId") Long productId);





    }

