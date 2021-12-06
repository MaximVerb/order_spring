package com.switchfully.order.spring_exercise.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    private final String street;
    private final String streetNumber;
    private final String city;
    private final int postalCode;
}