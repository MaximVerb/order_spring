package com.switchfully.order.spring_exercise.repositories.order;

import com.switchfully.order.spring_exercise.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final ConcurrentHashMap <String, Order> ordersById;

    public OrderRepositoryImpl() {
        this.ordersById = new ConcurrentHashMap<>();
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(ordersById.values());
    }

    @Override
    public void save(Order order) {
        ordersById.put(order.getId(), order);
    }

    @Override
    public List<Order> getOrdersByUserId(String id) {
        return ordersById.values().stream()
                .filter(order -> order.getUser().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> getOrderByOrderId(String id) {
        return Optional.of(ordersById.get(id));
    }
}
