package com.company.product.controller;

import com.company.product.RequestDto.CommentCreateRequest;
import com.company.product.entity.CommentEntity;
import com.company.product.responseDto.CommentResponse;
import com.company.product.service.concrete.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping
    public List<CommentResponse> getAllComments(@RequestParam Optional<Long> productId
                                               ) {
        return commentService.getAllCommentsWithParam(productId);
    }

    @PostMapping
    public CommentEntity createOneComment(@RequestBody CommentCreateRequest request) {
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public CommentResponse getOneComment(@PathVariable Long commentId) {
        return  commentService.getOneCommentById(commentId);
    }



    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }
}
