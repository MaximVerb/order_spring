package com.switchfully.order.spring_exercise.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressInformationDto {
    @JsonProperty("city")
    private final String city;

    @JsonProperty("street")
    private final String street;

    @JsonProperty("street_number")
    private final String streetNumber;

    @JsonProperty("zip_code")
    private final int zipCode;
}
