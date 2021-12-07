package com.switchfully.order.spring_exercise.services.order;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class CreatedOrderDto {
    private final List<CreatedOrderedItemDto> createdOrderItemList;
    private final String userId;

    public CreatedOrderDto(List<CreatedOrderedItemDto> createdOrderItemList, String userId) {
        this.createdOrderItemList =  Objects.requireNonNull(createdOrderItemList);
        this.userId =  Objects.requireNonNull(userId);
    }
}
