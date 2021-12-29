package dev.trodrigues.springmongo.services.impl;

import dev.trodrigues.springmongo.models.dtos.PostDto;
import dev.trodrigues.springmongo.models.entities.Post;
import dev.trodrigues.springmongo.repositories.PostRepository;
import dev.trodrigues.springmongo.services.PostService;
import dev.trodrigues.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto findById(String postId) {
        var post = getEntityById(postId);

        return new PostDto(post);
    }

    @Override
    public List<PostDto> findPostsByTitle(String text) {
        return this.postRepository.searchByTitle(text).stream().map(PostDto::new).toList();
    }

    @Override
    public List<PostDto> fullSearch(String text, String start, String end) {
        var startMoment = convertMoment(start, Instant.ofEpochMilli(0));
        var endMoment = convertMoment(end, Instant.now());
        var posts = this.postRepository.fullSearch(text, startMoment, endMoment);

        return posts.stream().map(PostDto::new).toList();
    }

    private Post getEntityById(String postId) {
        return this.postRepository.findById(postId).orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    private Instant convertMoment(String moment, Instant defaultValue) {
        try {
            return Instant.parse(moment);
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
