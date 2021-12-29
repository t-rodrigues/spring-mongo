package dev.trodrigues.springmongo.config;

import dev.trodrigues.springmongo.models.embedded.Author;
import dev.trodrigues.springmongo.models.embedded.Comment;
import dev.trodrigues.springmongo.models.entities.Post;
import dev.trodrigues.springmongo.models.entities.User;
import dev.trodrigues.springmongo.repositories.PostRepository;
import dev.trodrigues.springmongo.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public LocalConfig(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void startDb() {
        this.userRepository.deleteAll();
        this.postRepository.deleteAll();

        var maria = new User(null, "Maria Brown", "maria@mail.com");
        var alex = new User(null, "Alex Brown", "alex@mail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        this.userRepository.saveAll(List.of(maria, alex, bob));

        var post1 = new Post(null, Instant.parse("2021-02-13T11:15:01Z"), "Partiu viagem",
                "Partiu viajar para São Paulo. Abraços", new Author(alex));
        var post2 = new Post(null, Instant.parse("2021-02-14T10:05:49Z"), "Bom dia", "Acordei feliz hoje",
                new Author(maria));

        var c1 = new Comment("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Author(alex));
        var c2 = new Comment("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Author(bob));
        var c3 = new Comment("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Author(alex));

        post1.getComments().addAll(List.of(c1, c2));
        post2.getComments().addAll(List.of(c3));
        this.postRepository.saveAll(List.of(post1, post2));

        maria.getPosts().addAll(List.of(post1, post2));
        this.userRepository.save(maria);
    }

}
