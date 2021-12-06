package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.services.dtos.user.CreateUserDto;
import com.switchfully.order.spring_exercise.services.dtos.user.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(CreateUserDto createUserDto);

    List<UserDto> getAllUsers();
}
