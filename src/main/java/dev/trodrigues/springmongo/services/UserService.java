package dev.trodrigues.springmongo.services;

import dev.trodrigues.springmongo.models.dtos.UserDto;
import dev.trodrigues.springmongo.models.dtos.UserInputDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(String userId);

    UserDto create(UserInputDto userInputDto);

}
