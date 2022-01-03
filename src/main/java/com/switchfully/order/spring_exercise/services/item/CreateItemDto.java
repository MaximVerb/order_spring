package com.switchfully.order.spring_exercise.services.item;

import com.switchfully.order.spring_exercise.domain.item.Warehouse;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@EqualsAndHashCode
@Builder
public class CreateItemDto {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Warehouse warehouse;

    private CreateItemDto(String name, String description, BigDecimal price,Warehouse warehouse) {
        this.name =  Objects.requireNonNull(name);
        this.description =  Objects.requireNonNull(description);
        this.price =  Objects.requireNonNull(price);
        this.warehouse = Objects.requireNonNull(warehouse);
    }
}
