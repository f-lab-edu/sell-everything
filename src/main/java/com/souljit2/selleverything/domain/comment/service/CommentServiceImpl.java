package com.souljit2.selleverything.domain.comment.service;

import com.souljit2.selleverything.domain.comment.mapper.CommentMapper;
import com.souljit2.selleverything.domain.comment.model.CommentDTO;
import com.souljit2.selleverything.domain.comment.model.CommentVO;
import com.souljit2.selleverything.domain.member.service.SessionAuthServiceImpl;
import com.souljit2.selleverything.domain.post.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    CommentMapper commentMapper;

    PostMapper postMapper;

    SessionAuthServiceImpl sessionAuthService;

    @Override
    public List<CommentVO> getCommentsByPostId(int postId) {
        return commentMapper.findCommentsByPostId(postId);
    }

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

    @Override
    public void updateCommentById(int id, String newComment) {
        commentMapper.updateCommentById(id, newComment);
    }

    @Override
    public void deleteCommentById(int id) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        commentMapper.deleteCommentById(id, sessionMemberId);
    }
}
