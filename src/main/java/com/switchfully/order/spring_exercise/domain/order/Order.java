package com.switchfully.order.spring_exercise.domain.order;

import com.switchfully.order.spring_exercise.domain.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Order {
    private BigDecimal totalCost;

    private final String id;
    private final List<OrderedItem> orderedItems;
    private final User user;

    private Order(Builder builder) {
        this.id = builder.id;
        this.orderedItems = builder.orderedItem;
        this.totalCost = builder.totalCost;
        this.user = builder.user;
    }

    public static class Builder {
        private final String id;
        private final List<OrderedItem> orderedItem;
        private final User user;

        private BigDecimal totalCost;

        public Builder(List<OrderedItem> orderedItem, User user) {
            this.id = UUID.randomUUID().toString();
            this.orderedItem = orderedItem;
            this.user = user;
        }

        public Builder withTotalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
