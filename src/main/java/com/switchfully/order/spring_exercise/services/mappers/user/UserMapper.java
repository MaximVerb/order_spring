package com.switchfully.order.spring_exercise.services.mappers.user;

import com.switchfully.order.spring_exercise.domain.User;
import com.switchfully.order.spring_exercise.services.dtos.user.CreateUserDto;
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
                .build();
    }
}
