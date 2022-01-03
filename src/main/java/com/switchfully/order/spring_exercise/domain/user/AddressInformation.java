package com.switchfully.order.spring_exercise.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressInformation {
    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "street_address", nullable = false)
    private String streetNumber;

    @Column(name = "city_name", nullable = false)
    private String city;

    @Column(name = "zipcode", nullable = false)
    private int zipCode;
}
