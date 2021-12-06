package com.switchfully.order.spring_exercise.domain.item;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Item {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Long stock;

    private Item(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
    }

    public static class Builder {
        private final String id;
        private final String name;
        private final String description;
        private final BigDecimal price;
        private final Long stock;

        public Builder(String name, String description, BigDecimal price, Long stock) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.description = description;
            this.price = price;
            this.stock = stock;
        }

        public Item build() {
            return new Item(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
