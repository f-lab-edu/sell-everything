package com.souljit2.selleverything.domain.like.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

    public void insertLike(int sessionMemberId, int postId);

    public void deleteLike(int sessionMemberId, int postId);
}
