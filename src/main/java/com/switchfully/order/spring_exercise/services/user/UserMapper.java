package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertDtoToUser(CreateUserDto createUserDto) {
        return new User.Builder(
                createUserDto.getFirstName(),
                createUserDto.getLastName(),
                createUserDto.getEmailAddress(),
                createUserDto.getPhoneNumber(),
                createUserDto.getAddress())
                .withRole(createUserDto.getUserRole())
                .withPassword(createUserDto.getPassword())
                .withUsername(createUserDto.getUsername())
                .build();
    }
}
