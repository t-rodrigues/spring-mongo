package dev.trodrigues.springmongo.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.trodrigues.springmongo.models.embedded.Author;
import dev.trodrigues.springmongo.models.embedded.Comment;
import dev.trodrigues.springmongo.models.entities.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "UTC")
    private Instant moment;
    private String title;
    private String body;

    private Author author;

    @Setter(value = AccessLevel.NONE)
    private Set<Comment> comments = new HashSet<>();

    public PostDto(Post post) {
        this.id = post.getId();
        this.moment = post.getMoment();
        this.title = post.getTitle();
        this.body = post.getBody();
        this.author = post.getAuthor();
        this.comments.addAll(post.getComments());
    }

}
