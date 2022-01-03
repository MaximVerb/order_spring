package com.switchfully.order.spring_exercise.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ContactInformation {
    @Column(name = "email", nullable = false)
    private String emailAddress;

    @Column(name = "mobile_phonenumber")
    private String mobilePhoneNumber;

    @Column(name = "home_phonenumber")
    private String homePhoneNumber;
}
