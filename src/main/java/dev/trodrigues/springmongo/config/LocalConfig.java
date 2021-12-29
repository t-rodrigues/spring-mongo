package dev.trodrigues.springmongo.config;

import dev.trodrigues.springmongo.models.entities.User;
import dev.trodrigues.springmongo.repositories.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    private final UserRepository userRepository;

    public LocalConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void startDb() {
        this.userRepository.deleteAll();

        var maria = new User(null, "Maria Brown", "maria@mail.com");
        var alex = new User(null, "Alex Brown", "alex@mail.com");

        this.userRepository.saveAll(List.of(maria, alex));
    }

}
