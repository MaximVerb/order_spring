package com.switchfully.order.spring_exercise.services.order;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static java.util.UUID.fromString;

@Getter
public class CreatedOrderDto {
    private final List<CreatedOrderedItemDto> createdOrderItemList;
    private final Long userId;

    public CreatedOrderDto(List<CreatedOrderedItemDto> createdOrderItemList, Long userId) {
        this.createdOrderItemList =  Objects.requireNonNull(createdOrderItemList);
        this.userId =  Objects.requireNonNull(userId);
    }
}
