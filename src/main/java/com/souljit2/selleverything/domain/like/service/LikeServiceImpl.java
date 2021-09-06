package com.souljit2.selleverything.domain.like.service;

import com.souljit2.selleverything.domain.like.mapper.LikeMapper;
import com.souljit2.selleverything.domain.like.model.LikeVO;
import com.souljit2.selleverything.domain.member.service.SessionAuthServiceImpl;
import com.souljit2.selleverything.domain.post.mapper.PostMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    LikeMapper likeMapper;

    PostMapper postMapper;

    SessionAuthServiceImpl sessionAuthService;

    @Override
    @Transactional
    public void likePost(int postId) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        likeMapper.insertLike(sessionMemberId, postId);
        postMapper.increasePostLikeCountById(postId);
    }

    @Override
    @Transactional
    public void unlikePost(int postId) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        likeMapper.deleteLike(sessionMemberId, postId);
        postMapper.decreasePostLikeCountById(postId);
    }

    @Override
    public List<LikeVO> getLikesByPostId(int postId) {
        return likeMapper.findLikesById(postId);
    }
}
