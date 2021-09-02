package com.souljit2.selleverything.post;

import com.souljit2.selleverything.model.PostDTO;
import com.souljit2.selleverything.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/apis/posts")
public class PostController {

    PostService postService;

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable("id") int id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<PostDTO> getPostsByQueryString(@RequestParam Map<String, String> queryMap) {
        return postService.getPostsByQueryString(queryMap);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createPost(@RequestBody PostDTO newPost) {
        postService.createPost(newPost);
    }

    /**
     * @param id: 변경할 게시글의 id
     * @param newPost: 변경할 게시글의 내용
     */
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int id, @RequestBody PostDTO newPost) {
        postService.updatePostById(id, newPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable("id") int id) {
        postService.deletePostById(id);
    }
}
