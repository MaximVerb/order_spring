package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.item.Item;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatedOrderedItem {
    private final long amountOrderd;
    private final Item item;
    private LocalDateTime shippingDate;

    public CreatedOrderedItem(long amountOrderd, Item item) {
        this.amountOrderd = amountOrderd;
        this.item = item;
    }

    public CreatedOrderedItem withShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
