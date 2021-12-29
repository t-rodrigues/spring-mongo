package dev.trodrigues.springmongo.services.impl;

import dev.trodrigues.springmongo.models.dtos.UserDto;
import dev.trodrigues.springmongo.repositories.UserRepository;
import dev.trodrigues.springmongo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        var users = this.userRepository.findAll();

        return users.stream().map(UserDto::new).toList();
    }

}
