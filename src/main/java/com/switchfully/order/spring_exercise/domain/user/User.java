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

    private String username;
    private UserRole userRole;
    private String password;

    private User(Builder builder) {
        this.id = builder.id ;
        this.firstName =  builder.firstName ;
        this.lastName =  builder.lastName;
        this.emailAddress =  builder.emailAddress;
        this.phoneNumber =  builder.phoneNumber;
        this.address =  builder.address;
        this.userRole = builder.userRole;
        this.password = builder.password;
        this.username = builder.username;
    }

    public static class Builder {
        private final String id;
        private final String firstName;
        private final String lastName;
        private final String emailAddress;
        private final String phoneNumber;
        private final Address address;

        private String username;
        private UserRole userRole;
        private String password;

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

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setPassword(String password) {
        this.password = password;
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
