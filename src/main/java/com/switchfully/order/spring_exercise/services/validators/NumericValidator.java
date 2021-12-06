package com.switchfully.order.spring_exercise.services.validators;

public class NumericValidator {
    public static boolean isNotZero(long number) {
        if(number > 0) {
            return true;}
        throw new IllegalArgumentException();
    }
}
