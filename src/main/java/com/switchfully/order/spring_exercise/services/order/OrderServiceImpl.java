package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.repositories.item.ItemRepository;
import com.switchfully.order.spring_exercise.repositories.order.OrderRepository;
import com.switchfully.order.spring_exercise.repositories.order.OrderRepositoryImpl;
import com.switchfully.order.spring_exercise.repositories.order.OrderedItemRepository;
import com.switchfully.order.spring_exercise.repositories.user.UserRepository;
import com.switchfully.order.spring_exercise.services.user.UserDto;
import com.switchfully.order.spring_exercise.services.user.UserMapper;
import com.switchfully.order.spring_exercise.services.validators.NumericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private static final int PLUS_ONE_DAY = 1;
    private static final int PLUS_ONE_WEEK = 7;

    private final OrderRepository orderRepository;
    private final OrderedItemRepository orderedItemRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderedItemRepository orderedItemRepository,
                            ItemRepository itemRepository, UserRepository userRepository,
                            OrderMapper orderMapper, UserMapper userMapper) {
        this.orderRepository = orderRepository;
        this.orderedItemRepository = orderedItemRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Map<UserDto, List<OrderDto>> getAllOrdersByUser() {
//        return orderRepository.getAllOrders()
//                .stream()
//                .collect(Collectors.groupingBy(Order::getUser))
//                .entrySet()
//                .stream()
//                .map((key, value) -> { new UserDto(key);
//                                        new OrderDto(value;
        return null;
    }

    @Override
    public List<CreatedOrderedItem> createOrderedItemList(List<CreatedOrderedItem> createdOrderItemList) {
        if (isCreatedOrderItemGivenAmountValid(createdOrderItemList)) {
            createdOrderItemList.forEach(this::setCorrectShippingDate);
            return createdOrderItemList;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public OrderDto createAnOrder(CreatedOrderDto createdOrderDto) {
        List<OrderedItem> orderedItemList = orderMapper.convertDtosToOrderedItems(createOrderedItemList(createdOrderDto.getCreatedOrderItemList()));
        User user = userRepository.getUserById(createdOrderDto.getUserId());
        Order order = orderMapper.convertDtoToOrder(createdOrderDto, orderedItemList, user);
        orderedItemRepository.save(orderedItemList, order);
        orderRepository.save(order);
        return new OrderDto(order);
    }


    private void setCorrectShippingDate(CreatedOrderedItem createdOrderedItem) {
        Item itemInDB = itemRepository.getItem(createdOrderedItem.getItem());
        if (itemInDB.getStock() > 0) {
            createdOrderedItem.withShippingDate(LocalDateTime.now().plusDays(PLUS_ONE_DAY));
            reduceStockItem(itemInDB);
        } else {
            createdOrderedItem.withShippingDate(LocalDateTime.now().plusDays(PLUS_ONE_WEEK));
            reduceStockItem(itemInDB);
        }
    }

    private boolean isCreatedOrderItemGivenAmountValid(List<CreatedOrderedItem> createdOrderItemList) {
        return createdOrderItemList.stream()
                .allMatch(createdOrderedItem ->
                        NumericValidator.isNotZero(createdOrderedItem.getAmountOrderd()));
    }

    private void reduceStockItem(Item item) {
        item.withStock(item.getStock() - 1);
    }


}
