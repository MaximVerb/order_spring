package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.services.item.CreateItemDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class CreatedOrderedItemDto {
    private final Long amountOrdered;
    private final String description;
    private final CreateItemDto createItemDto;

    private LocalDateTime shippingDate;

    public CreatedOrderedItemDto(Long amountOrdered, String description, CreateItemDto createItemDto) {
        this.amountOrdered = amountOrdered;
        this.description = description;
        this.createItemDto = createItemDto;
    }

    void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }
}
