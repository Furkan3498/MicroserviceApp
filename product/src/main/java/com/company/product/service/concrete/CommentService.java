package com.company.product.service.concrete;

import com.company.product.RequestDto.CommentCreateRequest;
import com.company.product.RequestDto.DtoConverter;
import com.company.product.entity.ProductEntity;
import com.company.product.entity.CommentEntity;
import com.company.product.repository.CommentRepository;
import com.company.product.repository.ProductRepository;
import com.company.product.responseDto.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;
    private final DtoConverter dtoConverter;

    public CommentService(CommentRepository commentRepository, ProductServiceImpl productService, ProductRepository productRepository, DtoConverter dtoConverter) {
        this.commentRepository = commentRepository;
        this.productService = productService;
        this.productRepository = productRepository;
        this.dtoConverter = dtoConverter;
    }


    public CommentResponse getAllCommentsWithParam(CommentCreateRequest request) {
        ProductEntity productEntity= productService.getProductByIdForComment(request.getProductId());
        if (productEntity.getId() == null  ){
            throw new RuntimeException("Customer Not Found");
        }
        CommentEntity comment = new CommentEntity();
        comment.setText(request.getText());
        comment.setProductId(request.getProductId());

        return dtoConverter.convert(commentRepository.save(comment));
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
