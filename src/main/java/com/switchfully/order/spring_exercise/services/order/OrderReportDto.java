package com.switchfully.order.spring_exercise.services.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class OrderReportDto {
    @JsonProperty("user")
    private final String userId;

    @JsonIgnoreProperties({"description", "shippingDate"})
    @JsonProperty("ordered_items")
    private final List<OrderedItemDto> orderedItemDtoList;

    @JsonProperty("total_price_order")
    private final BigDecimal totalPriceCompleteOrder;

    private OrderReportDto(String userId, List<OrderedItemDto> orderedItemDtoList, BigDecimal totalPriceCompleteOrder) {
        this.userId = userId;
        this.orderedItemDtoList = orderedItemDtoList;
        this.totalPriceCompleteOrder = totalPriceCompleteOrder;
    }

    private OrderReportDto(Builder builder) {
        this.userId = builder.userId;
        this.orderedItemDtoList = builder.orderedItemDtoList;
        this.totalPriceCompleteOrder = builder.totalPriceCompleteOrder;
    }

    public static class Builder {
        private final String userId;
        private List<OrderedItemDto> orderedItemDtoList;
        private BigDecimal totalPriceCompleteOrder;

        public Builder(String userId) {
            this.userId = userId;
        }

        public Builder withOrderedItemDtoList(List<OrderedItemDto> orderedItemDtoList) {
            this.orderedItemDtoList = orderedItemDtoList;
            return this;
        }

        public Builder withTotalPriceCompleteOrder(BigDecimal totalPriceCompleteOrder) {
            this.totalPriceCompleteOrder = totalPriceCompleteOrder;
            return this;
        }

        public OrderReportDto build() {
            return new OrderReportDto(this);
        }
    }
}
