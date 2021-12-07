package com.switchfully.order.spring_exercise.services.item;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UpdatedItemDto {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Long stock;

    private UpdatedItemDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
    }

    private UpdatedItemDto(String id, String name, String description, BigDecimal price, Long stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public static class Builder {
        private final String id;
        private final BigDecimal price;
        private final Long stock;

        private String name;
        private String description;

        public Builder(String id, BigDecimal price, Long stock) {
            this.id = id;
            this.price = price;
            this.stock = stock;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdatedItemDto build() {
            return new UpdatedItemDto(this);
        }
    }
}
