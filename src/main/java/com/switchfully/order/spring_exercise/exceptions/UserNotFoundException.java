package com.switchfully.order.spring_exercise.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        this("Could not find user");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
