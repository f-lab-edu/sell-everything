package com.souljit2.selleverything.domain.comment.service;

import com.souljit2.selleverything.domain.comment.mapper.CommentMapper;
import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.member.service.SessionAuthServiceImpl;
import com.souljit2.selleverything.domain.post.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    CommentMapper commentMapper;

    PostMapper postMapper;

    SessionAuthServiceImpl sessionAuthService;

    @Override
    @Transactional
    public void createComment(CommentDTO newComment) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        commentMapper.insertComment(
            CommentDTO.builder()
                .memberIdFk(sessionMemberId)
                .commentContents(newComment.getCommentContents())
                .postIdFk(newComment.getPostIdFk())
                .build()
        );
        postMapper.increasePostCommentCountById(
            newComment.getPostIdFk()
        );
    }
}
