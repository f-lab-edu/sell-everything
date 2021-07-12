package com.souljit2.selleverything.service;

import com.souljit2.selleverything.mapper.PostMapper;
import com.souljit2.selleverything.model.PostDTO;
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

    @Override
    public PostDTO getPostById(int id) {
        return postMapper.getPostById(id);
    }

    @Cacheable(value = "MULTIPLE_POST")
    @Override
    public List<PostDTO> getPostsByQueryString(Map<String, String> queryMap) {
        return postMapper.getPosts(queryMap);
    }

    @CacheEvict(value = "MULTIPLE_POST", allEntries = true)
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
}
