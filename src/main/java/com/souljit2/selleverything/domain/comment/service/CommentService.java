package com.souljit2.selleverything.domain.comment.service;

import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.comment.model.CommentVO;

import java.util.List;

public interface CommentService {

    public List<CommentVO> getCommentsByPostId(int postId);

    public void createComment(CommentDTO postId);

    public void updateCommentById(int id, String newComment);

    public void deleteCommentById(int id);

}
