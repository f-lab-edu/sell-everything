package com.souljit2.selleverything.domain.post.service;

import com.souljit2.selleverything.domain.post.model.PostVO;
import com.souljit2.selleverything.global.constants.CacheNames;
import com.souljit2.selleverything.domain.post.model.PostDTO;
import com.souljit2.selleverything.domain.member.service.AuthService;
import com.souljit2.selleverything.domain.member.service.SessionAuthServiceImpl;
import com.souljit2.selleverything.domain.post.mapper.PostMapper;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostMapper postMapper;

    AuthService authService;

    SessionAuthServiceImpl sessionAuthService;

    @Override
    public PostVO getPostById(int id) {
        return postMapper.getPostById(id);
    }

    @Cacheable(value = CacheNames.POST)
    @Override
    public List<PostVO> getPostsByQueryString(Map<String, String> queryMap) {
        return postMapper.getPosts(queryMap);
    }

    @CacheEvict(value = CacheNames.POST, allEntries = true)
    @Override
    public void createPost(PostDTO newPost) {
        int memberIdBySession = authService.getRequestMemberId();
        postMapper.createPost(PostDTO.builder()
            .postTitle(newPost.getPostTitle())
            .postContents(newPost.getPostContents())
            .postItemName(newPost.getPostItemName())
            .postItemPrice(newPost.getPostItemPrice())
            .postCategory(newPost.getPostCategory())
            .memberIdFk(memberIdBySession)
            .build()
        );
    }

    @CacheEvict(value = CacheNames.POST, allEntries = true)
    @Override
    public void updatePostById(int id, PostDTO newPost) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        postMapper.updatePostById(id, sessionMemberId, newPost);
    }

    @CacheEvict(value = CacheNames.POST, allEntries = true)
    @Override
    public void deletePostById(int id) {
        int sessionMemberId = sessionAuthService.getRequestMemberId();
        postMapper.deletePostById(id, sessionMemberId);
    }

    @Override
    public void increasePostLikeCount(int postId) {
        postMapper.increasePostLikeCountById(postId);
    }

    @Override
    public void decreasePostLikeCount(int postId) {
        postMapper.decreasePostLikeCountById(postId);
    }
}
