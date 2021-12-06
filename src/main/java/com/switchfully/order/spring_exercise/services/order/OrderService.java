package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.services.user.UserDto;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<UserDto, List<OrderDto>> getAllOrdersByUser();
    List<CreatedOrderedItem> createOrderedItemList(List<CreatedOrderedItem> createdOrderItemList);
    OrderDto createAnOrder(CreatedOrderDto createdOrderDto);
}
