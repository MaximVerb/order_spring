package com.switchfully.order.spring_exercise.custom;

public class ItemCouldNotBeFoundExc extends RuntimeException{
    public ItemCouldNotBeFoundExc() {
        this("The item could not be found");
    }

    public ItemCouldNotBeFoundExc(String message) {
        super(message);
    }
}
