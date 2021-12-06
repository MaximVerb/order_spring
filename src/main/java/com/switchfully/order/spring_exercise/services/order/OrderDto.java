package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.services.user.UserDto;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderDto {
    private final List<OrderedItemDto> orderedItemDtoList;
    private final BigDecimal totalCost;
    private final UserDto user;

    public OrderDto(Order order) {
        this.orderedItemDtoList = order.getOrderedItems()
                .stream()
                .map(OrderedItemDto::new)
                .collect(Collectors.toList());
        this.totalCost = order.getTotalCost();
        this.user = new UserDto(order.getUser());
    }
}
