package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Getter
public class OrderedItemDto {
    private final long amountOrdered;
    private final String description;
    private final String name;
    private final String shippingDate;
    private final BigDecimal totalCostOrderedItems;

    public OrderedItemDto(OrderedItem orderedItem) {
        this.amountOrdered = orderedItem.getAmountOrdered();
        this.name = orderedItem.getName();
        this.description = orderedItem.getDescription();
        this.shippingDate = DateTimeFormatter.ISO_DATE.format(orderedItem.getShippingDate());
        this.totalCostOrderedItems = orderedItem.getTotalCostOrderedItems();
    }
}
