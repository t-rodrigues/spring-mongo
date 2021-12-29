package dev.trodrigues.springmongo.services;

import dev.trodrigues.springmongo.models.dtos.PostDto;

import java.util.List;

public interface PostService {

    PostDto findById(String postId);

    List<PostDto> findPostsByTitle(String text);

    List<PostDto> fullSearch(String text, String start, String end);

}
