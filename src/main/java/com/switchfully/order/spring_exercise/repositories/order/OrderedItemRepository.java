package com.switchfully.order.spring_exercise.repositories.order;

import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;

import java.util.List;

public interface OrderedItemRepository {
    void save(List<OrderedItem> orderedItems, Order order);
}
