package com.souljit2.selleverything.service;

import com.souljit2.selleverything.model.PostDTO;

import java.util.List;
import java.util.Map;

public interface PostService {

    public PostDTO getPostById(int id);

    public List<PostDTO> getPostsByQueryString(Map<String, String> queryMap);

}
