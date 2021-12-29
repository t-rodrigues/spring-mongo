package dev.trodrigues.springmongo.controllers;

import dev.trodrigues.springmongo.models.dtos.PostDto;
import dev.trodrigues.springmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String postId) {
        var post = this.postService.findById(postId);

        return ResponseEntity.ok(post);
    }

}
