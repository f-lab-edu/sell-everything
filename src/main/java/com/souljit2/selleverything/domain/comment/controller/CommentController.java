package com.souljit2.selleverything.domain.comment.controller;

import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.comment.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/comments")
public class CommentController {

    CommentService commentService;

    @PostMapping
    public void createComment(CommentDTO newComment) {
        commentService.createComment(newComment);
    }
}
