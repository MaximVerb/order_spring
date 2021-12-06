package com.switchfully.order.spring_exercise.domain.order;

import com.switchfully.order.spring_exercise.domain.item.Item;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class OrderedItem {
    private String orderId; //to which order is this orderedItem assigned

    private final long amountOrderd;
    private final Item item;
    private final LocalDateTime shippingDate;

    public OrderedItem(long amountOrderd, Item item, LocalDateTime shippingDate) {
        this.amountOrderd = amountOrderd;
        this.item = item;
        this.shippingDate = shippingDate;
    }

    public OrderedItem withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
}
