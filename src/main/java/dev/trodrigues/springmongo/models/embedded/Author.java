package dev.trodrigues.springmongo.models.embedded;

import dev.trodrigues.springmongo.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private String id;
    private String name;

    public Author(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

}
