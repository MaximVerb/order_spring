package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderedItemDto {
    private final long amountOrderd;
    private final Item item;
    private final LocalDateTime shippingDate;

    public OrderedItemDto(OrderedItem orderedItem) {
        this.amountOrderd = orderedItem.getAmountOrderd();
        this.item = orderedItem.getItem();
        this.shippingDate = orderedItem.getShippingDate();
    }
}
