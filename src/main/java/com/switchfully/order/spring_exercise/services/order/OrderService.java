package com.switchfully.order.spring_exercise.services.order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    List<CreatedOrderedItemDto> createOrderedItemList(List<CreatedOrderedItemDto> createdOrderItemList);
    OrderDto createOrder(CreatedOrderDto createdOrderDto);
    OrderReportDto getOrderReport(String id);
}
