package dev.trodrigues.springmongo.controllers;

import dev.trodrigues.springmongo.models.dtos.UserDto;
import dev.trodrigues.springmongo.models.dtos.UserInputDto;
import dev.trodrigues.springmongo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserInputDto userInputDto) {
        var user = this.userService.create(userInputDto);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String userId,
            @RequestBody @Valid UserInputDto userInputDto) {
        var user = this.userService.update(userId, userInputDto);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        this.userService.delete(userId);

        return ResponseEntity.noContent().build();
    }

}
