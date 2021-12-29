package dev.trodrigues.springmongo.controllers;

import dev.trodrigues.springmongo.models.dtos.UserDto;
import dev.trodrigues.springmongo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        var users = this.userService.findAll();

        return ResponseEntity.ok(users);
    }

}
