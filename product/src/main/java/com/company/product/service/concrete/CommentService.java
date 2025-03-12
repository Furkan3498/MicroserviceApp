package com.company.product.service.concrete;

import com.company.product.RequestDto.CommentCreateRequest;
import com.company.product.entity.ProductEntity;
import com.company.product.entity.CommentEntity;
import com.company.product.repository.CommentRepository;
import com.company.product.responseDto.CommentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ProductServiceImpl productService;

    public CommentService(CommentRepository commentRepository, ProductServiceImpl productService) {
        this.commentRepository = commentRepository;
        this.productService = productService;
    }


    public List<CommentResponse> getAllCommentsWithParam(Optional<Long> productId) {
        if (productId.isPresent()) {
            List<CommentEntity> comments = commentRepository.findByProduct_Id(productId.get());
            return comments.stream()
                    .map(CommentResponse::new)
                    .collect(Collectors.toList());
        }

        // Eğer productId yoksa boş liste döndür
        return Collections.emptyList();
    }


    public CommentResponse getOneCommentById(Long commentId) {
        CommentEntity commentEntity = commentRepository.findById(commentId).orElse(null);
     CommentResponse commentResponse = new CommentResponse();
     commentResponse.setName(commentEntity.getProductEntity());
     commentResponse.setText(commentEntity.getText());
     return commentResponse;
    }


    public CommentEntity createOneComment(CommentCreateRequest request) {

        ProductEntity productEntity = productService.getProductByIdForComment(request.getProductId());
        if (productEntity.getId() != null){
            CommentEntity comment = new CommentEntity();
            comment.setId(request.getId());
            comment.setText(request.getText());
            comment.setProductEntity(productEntity);
            comment.setCreateDate( LocalDateTime.now());
            return commentRepository.save(comment);
        }else
            return null;
    }

    public boolean deleteOneCommentById(Long commentId) {
        Optional<CommentEntity> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            commentRepository.deleteById(commentId);
            return true;
        }
        return false;
    }
}
