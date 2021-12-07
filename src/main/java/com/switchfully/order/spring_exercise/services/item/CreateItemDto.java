package com.switchfully.order.spring_exercise.services.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public class CreateItemDto {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Long stock;

    private CreateItemDto(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
    }

    private CreateItemDto(String name, String description, BigDecimal price, Long stock) {
        this.name =  Objects.requireNonNull(name);
        this.description =  Objects.requireNonNull(description);
        this.price =  Objects.requireNonNull(price);
        this.stock =  Objects.requireNonNull(stock);
    }

    public static class Builder {
        private final String name;
        private final String description;
        private final BigDecimal price;
        private final Long stock;

        public Builder(String name, String description, BigDecimal price, Long stock) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.stock = stock;
        }

        public CreateItemDto build() {
            return new CreateItemDto(this);
        }
    }
}
