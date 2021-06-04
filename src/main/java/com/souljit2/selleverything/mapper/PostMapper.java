package com.souljit2.selleverything.mapper;

import com.souljit2.selleverything.model.PostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

    public PostDTO getPostById(int id);

}
