package com.company.product.repository;

import com.company.product.entity.CommentEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {



}
