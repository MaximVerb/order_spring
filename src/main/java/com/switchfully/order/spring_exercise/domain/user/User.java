package com.switchfully.order.spring_exercise.domain.user;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String phoneNumber;
    private final Address address;

    private UserRole userRole;

    private User(Builder builder) {
        this.id = builder.id ;
        this.firstName =  builder.firstName ;
        this.lastName =  builder.lastName;
        this.emailAddress =  builder.emailAddress;
        this.phoneNumber =  builder.phoneNumber;
        this.address =  builder.address;
        this.userRole = builder.userRole;
    }

    public static class Builder {
        private final String id;
        private final String firstName;
        private final String lastName;
        private final String emailAddress;
        private final String phoneNumber;
        private final Address address;

        private UserRole userRole;

        public Builder(String firstName, String lastName, String emailAddress, String phoneNumber, Address address) {
            this.id = UUID.randomUUID().toString();
            this.firstName = firstName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public Builder withRole(UserRole role) {
            this.userRole = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
