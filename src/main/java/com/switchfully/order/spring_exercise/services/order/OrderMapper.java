package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import com.switchfully.order.spring_exercise.domain.user.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public List<OrderedItem> convertDtosToOrderedItems(List<CreatedOrderedItem> createdOrderItemList) {
        return createdOrderItemList.stream()
                .map(createdOrderedItem -> new OrderedItem(createdOrderedItem.getAmountOrderd(), createdOrderedItem.getItem(), createdOrderedItem.getShippingDate()))
                .collect(Collectors.toList());
    }

    public Order convertDtoToOrder(CreatedOrderDto createdOrderDto, List<OrderedItem> orderedItemList, User user) {
        return new Order.Builder(orderedItemList, user)
                .withTotalCost(orderedItemList.stream()
                        .map(orderedItem -> orderedItem.getItem().getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .build();
    }
}
