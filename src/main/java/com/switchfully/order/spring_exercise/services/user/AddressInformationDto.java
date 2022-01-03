package com.switchfully.order.spring_exercise.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AddressInformationDto {
    @JsonProperty("city")
    private final String city;

    @JsonProperty("street")
    private final String street;

    @JsonProperty("street_number")
    private final String streetNumber;

    @JsonProperty("zip_code")
    private final int zipCode;

    public AddressInformationDto(String city, String street,
                                 String streetNumber, int zipCode) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }
}
