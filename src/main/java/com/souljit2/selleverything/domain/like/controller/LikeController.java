package com.souljit2.selleverything.domain.like.controller;

import com.souljit2.selleverything.domain.like.model.LikeVO;
import com.souljit2.selleverything.domain.like.service.LikeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/likes")
public class LikeController {

    LikeService likeService;

    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LikeVO> getLikesByPostId(@PathVariable int postId) {
        return likeService.getLikesByPostId(postId);
    }

    @PostMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void likePost(@PathVariable int postId) {
        likeService.likePost(postId);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlikePost(@PathVariable int postId) {
        likeService.unlikePost(postId);
    }
}
