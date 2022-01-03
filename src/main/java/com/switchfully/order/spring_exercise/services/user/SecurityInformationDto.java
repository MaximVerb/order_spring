package com.switchfully.order.spring_exercise.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.spring_exercise.domain.user.UserRole;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class SecurityInformationDto {
    @JsonProperty("username")
    private final String username;

    @JsonProperty("password")
    private final String password;

    @JsonProperty("role")
    private final String role;

    public SecurityInformationDto(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = checkRole(role);
    }

    private String checkRole(String role) {
        return Arrays.stream(UserRole.values())
                .map(Enum::name)
                .filter(name -> name.equals(role))
                .findAny().orElse(UserRole.CUSTOMER.name());
    }
}
