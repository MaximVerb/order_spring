package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.services.item.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private ItemMapper itemMapper;

    @Autowired
    public OrderMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    private final Function <CreatedOrderedItemDto, OrderedItem> convertDtoToEntity =
            dto -> OrderedItem.builder()
                    .amountOrdered(dto.getAmountOrdered())
                    .shippingDate(dto.getShippingDate())
                    .item(itemMapper.convertDtoToItem(dto.getCreateItemDto()))
                    .build();

    public List<OrderedItem> convertDtosToOrderedItems(List<CreatedOrderedItemDto> createdOrderItemList) {
        return createdOrderItemList.stream()
                .map(convertDtoToEntity)
                .collect(Collectors.toList());
    }

    public Order convertOrderDtoToOrder(List<OrderedItem> orderedItemList, User user) {
        return Order.builder()
                .orderedItems(orderedItemList)
                .user(user)
                .build();
    }

    public List<OrderDto> convertOrderToOrderDto(List<Order> allOrders) {
        return allOrders.stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
    }

    public OrderReportDto convertOrderToOrderReportDto(String id, List<Order> allOrdersByUser, BigDecimal bigDecimal) {
       List<OrderedItemDto> orderedItemDtoList = allOrdersByUser.stream()
               .map(Order::getOrderedItems)
               .flatMap(Collection::stream)
               .map(OrderedItemDto::new)
               .collect(Collectors.toList());

       return new OrderReportDto.Builder(id)
               .withOrderedItemDtoList(orderedItemDtoList)
               .withTotalPriceCompleteOrder(bigDecimal)
               .build();
    }
}
