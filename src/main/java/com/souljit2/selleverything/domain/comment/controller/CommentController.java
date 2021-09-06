package com.souljit2.selleverything.domain.comment.controller;

import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.comment.model.CommentVO;
import com.souljit2.selleverything.domain.comment.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/comments")
public class CommentController {

    CommentService commentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{postId}")
    public List<CommentVO> getCommentsByPostId(@PathVariable int postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public void createComment(CommentDTO newComment) {
        commentService.createComment(newComment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public void updateCommentById(@PathVariable int id, @RequestParam String commentContents) {
        commentService.updateCommentById(id, commentContents);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable int id) {
        commentService.deleteCommentById(id);
    }

}
