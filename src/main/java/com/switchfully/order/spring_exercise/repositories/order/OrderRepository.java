package com.switchfully.order.spring_exercise.repositories.order;

import com.switchfully.order.spring_exercise.domain.order.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();
    void save(Order order);
    List<Order> getOrdersByUserId(String id);
}
