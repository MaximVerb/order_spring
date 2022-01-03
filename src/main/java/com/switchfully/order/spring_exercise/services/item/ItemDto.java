package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.domain.item.Warehouse;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@EqualsAndHashCode
@Getter
public class ItemDto {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Warehouse warehouse;

    public ItemDto(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.warehouse = item.getWarehouse();
    }
}
