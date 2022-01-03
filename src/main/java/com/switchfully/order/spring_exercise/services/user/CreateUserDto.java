package com.switchfully.order.spring_exercise.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.spring_exercise.domain.user.AddressInformation;
import com.switchfully.order.spring_exercise.domain.user.ContactInformation;
import com.switchfully.order.spring_exercise.domain.user.SecurityInformation;
import com.switchfully.order.spring_exercise.domain.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class CreateUserDto {
    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("contact_information")
    private ContactInformationDto contactInformationDto;

    @JsonProperty("security_information")
    private SecurityInformationDto securityInformationDto;

    @JsonProperty("address_information")
    private AddressInformationDto addressInformationDto;


    public CreateUserDto(String firstName, String lastName,
                         ContactInformationDto contactInformation,
                         SecurityInformationDto securityInformation,
                         AddressInformationDto addressInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInformationDto = contactInformation;
        this.securityInformationDto = securityInformation;
        this.addressInformationDto = addressInformation;
    }
}
