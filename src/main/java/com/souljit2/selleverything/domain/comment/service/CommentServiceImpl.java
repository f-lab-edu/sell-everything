package com.souljit2.selleverything.domain.comment.service;

import com.souljit2.selleverything.domain.comment.mapper.CommentMapper;
import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.member.service.SessionAuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    CommentMapper commentMapper;
    SessionAuthServiceImpl sessionAuthService;

    @Override
    public void createComment(CommentDTO newComment) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        commentMapper.insertComment(
            CommentDTO.builder()
                .memberIdFk(sessionMemberId)
                .commentContents(newComment.getCommentContents())
                .postIdFk(newComment.getPostIdFk())
                .build()
        );
    }
}
