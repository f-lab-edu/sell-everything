package com.souljit2.selleverything.domain.comment.mapper;

import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.comment.model.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public void insertComment(CommentDTO newComment);

    public List<CommentVO> findCommentsByPostId(int postId);

    public void updateCommentById(int id, String newComment);

    public void deleteCommentById(int id, int memberIdFk);

}