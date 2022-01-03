package com.switchfully.order.spring_exercise.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactInformationDto {
    @JsonProperty("email")
    private final String emailAddress;

    @JsonProperty("mobile_phonenumber")
    private final String mobilePhoneNumber;

    @JsonProperty("home_phonenumber")
    private final String homePhoneNumber;
}
