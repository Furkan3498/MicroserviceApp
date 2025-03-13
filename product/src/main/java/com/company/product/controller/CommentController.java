package com.company.product.controller;

import com.company.product.RequestDto.CommentCreateRequest;
import com.company.product.entity.CommentEntity;
import com.company.product.repository.CommentRepository;
import com.company.product.responseDto.CommentResponse;
import com.company.product.service.concrete.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")

public class CommentController {

    private final CommentService commentService;

    private final CommentRepository commentRepository;
    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }


    @PostMapping
    public CommentResponse getAllComments(@RequestBody  CommentCreateRequest request
                                               ) {
        return commentService.getAllCommentsWithParam(request);
    }

    @GetMapping("/{id}")
    public CommentEntity getComment(@PathVariable Long id){
        return commentRepository.findById(id).orElse(new CommentEntity());
    }

    @GetMapping
    public List<CommentEntity> getAllComments(){

        return  commentRepository.findAll();
    }




    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}
