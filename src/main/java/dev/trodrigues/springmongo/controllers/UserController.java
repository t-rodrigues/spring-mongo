package dev.trodrigues.springmongo.controllers;

import dev.trodrigues.springmongo.models.dtos.UserDto;
import dev.trodrigues.springmongo.models.dtos.UserInsertDto;
import dev.trodrigues.springmongo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        var user = this.userService.findById(userId);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserInsertDto userInsertDto) {
        var user = this.userService.create(userInsertDto);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

}
