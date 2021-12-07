package com.switchfully.order.spring_exercise.services.order;

import java.util.List;

public interface OrderService {
    List<CreatedOrderedItemDto> createOrderedItemList(List<CreatedOrderedItemDto> createdOrderItemList);
    OrderReportDto getOrderReport(String id);

    OrderDto createOrder(CreatedOrderDto createdOrderDto);
    OrderDto createRecurringOrder(String orderId);
    List<OrderDto> getAllOrders();
}
