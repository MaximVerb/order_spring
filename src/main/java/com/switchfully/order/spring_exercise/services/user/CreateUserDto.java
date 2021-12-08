package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.Address;
import com.switchfully.order.spring_exercise.domain.user.UserRole;
import lombok.Getter;

@Getter
public class CreateUserDto {
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;
    private final Address address;
    private final String username;
    private final UserRole userRole;
    private final String password;

    private CreateUserDto(Builder builder) {
        this.firstName =  builder.firstName ;
        this.lastName =  builder.lastName;
        this.emailAddress =  builder.emailAddress;
        this.phoneNumber =  builder.phoneNumber;
        this.address =  builder.address;
        this.username = builder.username;
        this.password = builder.password;
        this.userRole = builder.userRole;
    }

    private CreateUserDto(String firstName, String lastName, String emailAddress, String phoneNumber,
                         Address address, String username, UserRole userRole, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.userRole = userRole;
        this.password = password;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private final String emailAddress;
        private final String phoneNumber;
        private final Address address;

        private String username;
        private UserRole userRole;
        private String password;

        public Builder(String firstName, String lastName, String emailAddress, String phoneNumber, Address address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withUserRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CreateUserDto build() {
            return new CreateUserDto(this);
        }
    }
}
