package dev.trodrigues.springmongo.services;

import dev.trodrigues.springmongo.models.dtos.PostDto;

public interface PostService {

    PostDto findById(String postId);

}
