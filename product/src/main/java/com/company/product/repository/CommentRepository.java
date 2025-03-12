package com.company.product.repository;

import com.company.product.entity.commentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<commentEntity,Long> {

    List<commentEntity> findByProductId(Long productId);
}
