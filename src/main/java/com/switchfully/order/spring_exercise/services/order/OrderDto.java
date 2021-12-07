package com.switchfully.order.spring_exercise.services.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.services.user.UserDto;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonPropertyOrder({"orderId", "user", "orderedItemDtoList", "totalCost"})
public class OrderDto {
    @JsonProperty("order_identifier")
    private final String orderId;

    @JsonProperty("ordered_items")
    private final List<OrderedItemDto> orderedItemDtoList;

    @JsonProperty("customer")
    private final UserDto user;

    @JsonProperty("total_cost")
    private final BigDecimal totalCost;

    public OrderDto(Order order) {
        this.orderedItemDtoList = order.getOrderedItems()
                .stream()
                .map(OrderedItemDto::new)
                .collect(Collectors.toList());
        this.totalCost = order.getTotalCost();
        this.user = new UserDto(order.getUser());
        this.orderId = order.getId();
    }
}
