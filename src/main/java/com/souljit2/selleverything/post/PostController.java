package com.souljit2.selleverything.post;

import com.souljit2.selleverything.model.PostDTO;
import com.souljit2.selleverything.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/posts")
public class PostController {

    PostService postService;

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }
}
