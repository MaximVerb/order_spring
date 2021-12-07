package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class UserDto {
    private final String firstName;
    private final String lastName;
    private final String id; //testing purposes only FIXME

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.id = user.getId();
    }
}
