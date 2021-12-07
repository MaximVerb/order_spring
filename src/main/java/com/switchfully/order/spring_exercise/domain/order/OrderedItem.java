package com.switchfully.order.spring_exercise.domain.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class OrderedItem {
    /** composite key */
    private String orderId;
    private String itemId;

    private final long amountOrdered;
    private final String description;
    private final String name;
    private final LocalDateTime shippingDate;

    private BigDecimal totalCostOrderedItems;

    public OrderedItem(long amountOrdered, String description, String name, LocalDateTime shippingDate) {
        this.amountOrdered = amountOrdered;
        this.description = description;
        this.name = name;
        this.shippingDate = shippingDate;
    }

    public OrderedItem setTotalCostOrderedItems(BigDecimal totalCostOrderedItems) {
        this.totalCostOrderedItems = totalCostOrderedItems;
        return this;
    }
}
