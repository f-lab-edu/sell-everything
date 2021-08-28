package com.souljit2.selleverything.mapper;

import com.souljit2.selleverything.model.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {

    public PostDTO getPostById(int id);

    public List<PostDTO> getPosts(Map<String, String> columnConditions);

    public void createPost(PostDTO newPost);

    public void deletePostById(int id, int memberIdFk);
}