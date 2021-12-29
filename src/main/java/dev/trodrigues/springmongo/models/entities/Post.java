package dev.trodrigues.springmongo.models.entities;

import dev.trodrigues.springmongo.models.embedded.Author;
import dev.trodrigues.springmongo.models.embedded.Comment;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private Instant moment;
    private String title;
    private String body;

    private Author author;

    @Setter(value = AccessLevel.NONE)
    private Set<Comment> comments = new HashSet<>();

    public Post(String id, Instant moment, String title, String body, Author author) {
        this.id = id;
        this.moment = moment;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
