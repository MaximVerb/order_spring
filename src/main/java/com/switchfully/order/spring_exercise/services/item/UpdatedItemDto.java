package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Warehouse;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class UpdatedItemDto {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Warehouse warehouse;

    private UpdatedItemDto(String id, String name, String description, BigDecimal price, Warehouse warehouse) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.warehouse = warehouse;
    }
}
