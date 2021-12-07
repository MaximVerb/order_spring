package com.switchfully.order.spring_exercise.repositories.order;

import com.switchfully.order.spring_exercise.domain.order.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> getAllOrders();
    void save(Order order);
    List<Order> getOrdersByUserId(String id);
    Optional<Order> getOrderByOrderId(String id);
}
