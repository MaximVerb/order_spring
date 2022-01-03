package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.AddressInformation;
import com.switchfully.order.spring_exercise.domain.user.ContactInformation;
import com.switchfully.order.spring_exercise.domain.user.SecurityInformation;
import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.domain.user.UserRole;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import static com.switchfully.order.spring_exercise.domain.user.UserRole.getRole;

@Component
public class UserMapper {
    private final Function<AddressInformationDto, AddressInformation> AddressDtoToAddress =
            dto -> AddressInformation.builder()
                    .city(dto.getCity())
                    .zipCode(dto.getZipCode())
                    .street(dto.getStreet())
                    .streetNumber(dto.getStreetNumber())
                    .build();

    private final Function<ContactInformationDto, ContactInformation> ContactDtoToContact =
            dto -> ContactInformation.builder()
                    .emailAddress(dto.getEmailAddress())
                    .homePhoneNumber(dto.getHomePhoneNumber())
                    .mobilePhoneNumber(dto.getMobilePhoneNumber())
                    .build();

    private final Function<SecurityInformationDto, SecurityInformation> SecurityDtoToSecurity =
            dto -> SecurityInformation.builder()
                    .password(dto.getPassword())
                    .username(dto.getUsername())
                    .userRole(getRole(dto.getRole()))
                    .build();

    public User convertDtoToUser(CreateUserDto createUserDto) {
        return User.builder()
                .addressInformation(AddressDtoToAddress.apply(createUserDto.getAddressInformationDto()))
                .contactInformation(ContactDtoToContact.apply(createUserDto.getContactInformationDto()))
                .securityInformation(SecurityDtoToSecurity.apply(createUserDto.getSecurityInformationDto()))
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .build();
    }
}
