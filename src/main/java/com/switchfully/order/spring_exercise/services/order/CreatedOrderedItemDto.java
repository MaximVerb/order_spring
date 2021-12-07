package com.switchfully.order.spring_exercise.services.order;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class CreatedOrderedItemDto {
    private final long amountOrdered;
    private final String name;
    private final String description;
    private LocalDateTime shippingDate;

    public CreatedOrderedItemDto(long amountOrdered, String name, String description) {
        this.amountOrdered = amountOrdered;
        this.name =  Objects.requireNonNull(name);
        this.description =  Objects.requireNonNull(description);
    }

    CreatedOrderedItemDto setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
