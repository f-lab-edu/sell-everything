package com.souljit2.selleverything.domain.like.controller;

import com.souljit2.selleverything.domain.like.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/likes")
public class LikeController {

    LikeService likeService;

    @PostMapping("/{postId}")
    public void likePost(@PathVariable int postId) {
        likeService.likePost(postId);
    }

    @DeleteMapping("/{postId}")
    public void unlikePost(@PathVariable int postId) {
        likeService.unlikePost(postId);
    }
}
