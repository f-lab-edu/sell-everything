package com.souljit2.selleverything.domain.like.mapper;

import com.souljit2.selleverything.domain.like.model.LikeVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

    public void insertLike(int sessionMemberId, int postId);

    public void deleteLike(int sessionMemberId, int postId);

    public List<LikeVO> findLikesById(int postId);
}
