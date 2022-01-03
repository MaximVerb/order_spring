package com.switchfully.order.spring_exercise.domain.user;

public enum UserRole {
    ADMIN,
    CUSTOMER;

    public static UserRole getRole(String role) {
        switch(role) {
            case "ADMIN":
                return ADMIN;
            case "CUSTOMER":
            default:
                return CUSTOMER;
        }
    }
}
