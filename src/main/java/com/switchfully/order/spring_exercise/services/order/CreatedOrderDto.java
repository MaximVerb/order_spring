package com.switchfully.order.spring_exercise.services.order;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class CreatedOrderDto {
    private final List<CreatedOrderedItem> createdOrderItemList;
    private final BigDecimal totalCost;
    private final String userId;

    public CreatedOrderDto(List<CreatedOrderedItem> createdOrderItemList, BigDecimal totalCost, String userId) {
        this.createdOrderItemList = createdOrderItemList;
        this.totalCost = totalCost;
        this.userId = userId;
    }
}
