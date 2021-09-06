package com.souljit2.selleverything.domain.comment.mapper;

import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    public void insertComment(CommentDTO newComment);

}
