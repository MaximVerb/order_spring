package com.switchfully.order.spring_exercise.repositories.order;

import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderedItemRepositoryImpl implements OrderedItemRepository {
    private final ConcurrentHashMap<String, List< OrderedItem>> orderedItemByOrderId;

    public OrderedItemRepositoryImpl() {
        this.orderedItemByOrderId = new ConcurrentHashMap<>();
    }

    @Override
    public void save(List<OrderedItem> orderedItems, String orderId) {
        orderedItemByOrderId.put(orderId, orderedItems);
    }
}
