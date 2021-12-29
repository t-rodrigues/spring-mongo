package dev.trodrigues.springmongo.services.impl;

import dev.trodrigues.springmongo.models.dtos.UserDto;
import dev.trodrigues.springmongo.models.dtos.UserInputDto;
import dev.trodrigues.springmongo.repositories.UserRepository;
import dev.trodrigues.springmongo.services.UserService;
import dev.trodrigues.springmongo.services.exceptions.BusinessException;
import dev.trodrigues.springmongo.services.exceptions.ObjectNotFoundException;
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

    @Override
    public UserDto findById(String userId) {
        var user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));

        return new UserDto(user);
    }

    @Override
    public UserDto create(UserInputDto userInputDto) {
        checkIfEmailExists(userInputDto.getEmail());
        var user = userInputDto.toUserEntity();

        this.userRepository.insert(user);

        return new UserDto(user);
    }

    private void checkIfEmailExists(String email) {
        var emailExists = this.userRepository.findByEmail(email);

        if (emailExists.isPresent()) {
            throw new BusinessException("Email already exists");
        }
    }

}
