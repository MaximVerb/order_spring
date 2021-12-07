package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class UserDto {
    private final String id; //testing purposes only FIXME
    private final String firstName;
    private final String lastName;

    public UserDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
