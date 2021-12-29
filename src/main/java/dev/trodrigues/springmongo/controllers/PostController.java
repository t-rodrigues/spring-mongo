package dev.trodrigues.springmongo.controllers;

import dev.trodrigues.springmongo.models.dtos.PostDto;
import dev.trodrigues.springmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<PostDto>> getPostsByTitle(@RequestParam(defaultValue = "") String text) {
        var posts = this.postService.findPostsByTitle(text);

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostDto>> getPostsByTextAndMoment(
            @RequestParam(defaultValue = "") String text,
            @RequestParam(defaultValue = "") String start,
            @RequestParam(defaultValue = "") String end) {

        var posts = this.postService.fullSearch(text, start, end);

        return ResponseEntity.ok(posts);
    }

}
