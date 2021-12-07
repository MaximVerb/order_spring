package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.Address;
import lombok.Getter;

import java.util.Objects;

@Getter
public class CreateUserDto {
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;
    private final Address address;

    private CreateUserDto(Builder builder) {
        this.firstName =  builder.firstName ;
        this.lastName =  builder.lastName;
        this.emailAddress =  builder.emailAddress;
        this.phoneNumber =  builder.phoneNumber;
        this.address =  builder.address;
    }

    private CreateUserDto(String firstName, String lastName, String emailAddress, String phoneNumber, Address address) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName =  Objects.requireNonNull(lastName);
        this.emailAddress =  Objects.requireNonNull(emailAddress);
        this.phoneNumber =  Objects.requireNonNull(phoneNumber);
        this.address =  Objects.requireNonNull(address);
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private final String emailAddress;
        private final String phoneNumber;
        private final Address address;


        public Builder(String firstName, String lastName, String emailAddress, String phoneNumber, Address address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public CreateUserDto build() {
            return new CreateUserDto(this);
        }
    }
}
