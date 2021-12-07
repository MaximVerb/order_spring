package com.switchfully.order.spring_exercise.exceptions;

public class EntityCouldNotBeFoundExc extends RuntimeException{
    public EntityCouldNotBeFoundExc() {
        this("The item could not be found");
    }

    public EntityCouldNotBeFoundExc(String message) {
        super(message);
    }
}
