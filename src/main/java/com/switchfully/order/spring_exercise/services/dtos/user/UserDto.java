package com.switchfully.order.spring_exercise.services.dtos.user;

import com.switchfully.order.spring_exercise.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class UserDto {
    private final String firstName;
    private final String lastName;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
