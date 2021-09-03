package com.souljit2.selleverything.domain.like.service;

import com.souljit2.selleverything.domain.like.mapper.LikeMapper;
import com.souljit2.selleverything.domain.member.service.SessionAuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    LikeMapper likeMapper;

    SessionAuthServiceImpl sessionAuthService;

    @Override
    public void likePost(int postId) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        likeMapper.insertLike(sessionMemberId, postId);
    }

    @Override
    public void unlikePost(int postId) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        likeMapper.deleteLike(sessionMemberId, postId);
    }

}
