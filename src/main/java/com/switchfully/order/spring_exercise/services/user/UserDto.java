package com.switchfully.order.spring_exercise.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.spring_exercise.domain.user.User;
import lombok.Getter;

@Getter
public class UserDto {
    @JsonProperty("firstname")
    private final String firstName;

    @JsonProperty("lastname")
    private final String lastName;

    @JsonProperty("contact_information")
    private final ContactInformationDto contactInformationDto;

    @JsonProperty("address_information")
    private final AddressInformationDto addressInformationDto;

    @JsonProperty("security_information")
    private final SecurityInformationDto securityInformationDto;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.contactInformationDto = new ContactInformationDto(
                user.getContactInformation().getEmailAddress(),
                user.getContactInformation().getMobilePhoneNumber(),
                user.getContactInformation().getHomePhoneNumber()
        );
        this.addressInformationDto = new AddressInformationDto(
                user.getAddressInformation().getCity(),
                user.getAddressInformation().getStreet(),
                user.getAddressInformation().getStreetNumber(),
                user.getAddressInformation().getZipCode()
                );
        this.securityInformationDto = new SecurityInformationDto(
                user.getSecurityInformation().getUsername(),
                user.getSecurityInformation().getPassword(),
                user.getSecurityInformation().getUserRole().name()
        );
    }
}
