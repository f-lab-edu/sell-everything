package com.souljit2.selleverything.service;

import com.souljit2.selleverything.mapper.PostMapper;
import com.souljit2.selleverything.model.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostMapper postMapper;

    @Override
    public PostDTO getPostById(int id) {
        return postMapper.getPostById(id);
    }

    @Override
    public List<PostDTO> getPostsByQueryString(Map<String, String> queryMap) {
        return postMapper.getPosts(queryMap);
    }
}
