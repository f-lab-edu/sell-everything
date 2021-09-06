package com.souljit2.selleverything.domain.like.service;

import com.souljit2.selleverything.domain.like.model.LikeVO;
import java.util.List;

public interface LikeService {

    public void likePost(int postId);

    public void unlikePost(int postId);

    public List<LikeVO> getLikesByPostId(int postId);

}
