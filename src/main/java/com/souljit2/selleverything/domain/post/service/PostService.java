package com.souljit2.selleverything.domain.post.service;

import com.souljit2.selleverything.domain.post.model.PostDTO;

import java.util.List;
import java.util.Map;

public interface PostService {

    public PostDTO getPostById(int id);

    public List<PostDTO> getPostsByQueryString(Map<String, String> queryMap);

    public void createPost(PostDTO newPost);

    public void updatePostById(int id, PostDTO newPost);

    public void deletePostById(int id);

    public void increasePostLikeCount(int postId);

    public void decreasePostLikeCount(int postId);

}