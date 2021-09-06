package com.souljit2.selleverything.domain.comment.controller;

import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.comment.model.CommentVO;
import com.souljit2.selleverything.domain.comment.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/comments")
public class CommentController {

    CommentService commentService;

    @GetMapping("/{postId}")
    public List<CommentVO> getCommentsByPostId(@PathVariable int postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping
    public void createComment(CommentDTO newComment) {
        commentService.createComment(newComment);
    }
}
