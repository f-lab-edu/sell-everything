package com.souljit2.selleverything.domain.post.mapper;

import com.souljit2.selleverything.domain.post.model.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {

    public PostDTO getPostById(int id);

    public List<PostDTO> getPosts(Map<String, String> columnConditions);

    public void createPost(PostDTO newPost);

    public void deletePostById(int id, int sessionMemberId);

    public void updatePostById(int id, int sessionMemberId, PostDTO newPost);

    public void increasePostLikeCountById(int id);

    public void decreasePostLikeCountById(int id);

}