package dev.trodrigues.springmongo.models.dtos;

import dev.trodrigues.springmongo.models.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserInsertDto {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    public User toUserEntity() {
        return new User(null, this.name, this.email);
    }

}
