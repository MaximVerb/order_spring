package com.switchfully.order.spring_exercise.services.order;

import com.switchfully.order.spring_exercise.domain.item.Item;
import com.switchfully.order.spring_exercise.domain.order.Order;
import com.switchfully.order.spring_exercise.domain.order.OrderedItem;
import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.exceptions.EntityCouldNotBeFoundExc;
import com.switchfully.order.spring_exercise.repositories.item.ItemRepository;
import com.switchfully.order.spring_exercise.repositories.order.OrderRepository;
import com.switchfully.order.spring_exercise.repositories.order.OrderedItemRepository;
import com.switchfully.order.spring_exercise.repositories.user.UserRepository;
import com.switchfully.order.spring_exercise.services.validators.NumericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {
    private static final int PLUS_ONE_DAY = 1;
    private static final int PLUS_ONE_WEEK = 7;

    private final OrderRepository orderRepository;
    private final OrderedItemRepository orderedItemRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderedItemRepository orderedItemRepository,
                            ItemRepository itemRepository, UserRepository userRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderedItemRepository = orderedItemRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.getAllOrders();
        orderList.stream()
                .flatMap(order -> order.getOrderedItems().stream())
                .forEach(orderedItem -> {orderedItem.setTotalCostOrderedItems(setTotalCostOrderedItem(orderedItem));});
        return orderMapper.convertOrderToOrderDto(orderList);
    }

    @Override
    public List<CreatedOrderedItemDto> createOrderedItemList(List<CreatedOrderedItemDto> createdOrderItemList) {
        if (isCreatedOrderItemGivenAmountValid(createdOrderItemList)) {
            createdOrderItemList.forEach(this::setCorrectShippingDate);
            return createdOrderItemList;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public OrderDto createOrder(CreatedOrderDto createdOrderDto) {
        List<OrderedItem> orderedItemList = orderMapper.convertDtosToOrderedItems(createOrderedItemList(createdOrderDto.getCreatedOrderItemList()));
        User user = userRepository.getUserById(createdOrderDto.getUserId());
        Order order = orderMapper.convertOrderDtoToOrder(orderedItemList, user);
        order.withTotalCost(totalCostAllOrders(Stream.of(order)));
        orderedItemRepository.save(orderedItemList, order.getId());
        orderRepository.save(order);
        return new OrderDto(order);
    }

    //TODO hier moet nog een UserId check op gebeuren
    @Override
    public OrderDto createRecurringOrder(String orderId) {
        Order order = orderRepository.getOrderByOrderId(orderId).orElseThrow(() -> {throw new EntityCouldNotBeFoundExc();});

        Order newOrder = new Order.Builder(order.getOrderedItems(), order.getUser())
                .withTotalCost(totalCostAllOrders(Stream.of(order)))
                .build();

        totalPriceItemByItem(newOrder.getOrderedItems().stream());
        orderRepository.save(newOrder);
        return new OrderDto(newOrder);
    }

    @Override
    public OrderReportDto getOrderReport(String id) {
        List<Order> ordersByUser = orderRepository.getOrdersByUserId(id);
        ordersByUser.forEach(order -> totalPriceItemByItem(order.getOrderedItems().stream()));
        return orderMapper.convertOrderToOrderReportDto(id, ordersByUser, totalCostAllOrders(ordersByUser.stream()));
    }

    private void totalPriceItemByItem(Stream<OrderedItem> orderedItemStream) {
        orderedItemStream.forEach(orderedItem -> {
            orderedItem.setTotalCostOrderedItems(setTotalCostOrderedItem(orderedItem));
        });
    }

    private BigDecimal totalCostAllOrders(Stream<Order> orders) {
        return orders.map(Order::getOrderedItems)
                .map(this::totalCostOrder)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    private BigDecimal totalCostOrder(List<OrderedItem> orderedItemList) {
        Function<OrderedItem, BigDecimal> orderedItemToItsPrice =
                orderedItem -> itemRepository.getItemByNameAndDescription(orderedItem.getName(), orderedItem.getDescription()).getPrice();

        return orderedItemList.stream()
                .map(orderedItem -> orderedItemToItsPrice.apply(orderedItem).multiply(BigDecimal.valueOf(orderedItem.getAmountOrdered())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    private void setCorrectShippingDate(CreatedOrderedItemDto createdOrderedItem) {
        Item itemInDB = itemRepository.getItemByNameAndDescription(createdOrderedItem.getName(), createdOrderedItem.getDescription());
        if (isThereEnoughStock(createdOrderedItem, itemInDB)) {
            createdOrderedItem.setShippingDate(LocalDateTime.now().plusDays(PLUS_ONE_DAY));
        } else {
            createdOrderedItem.setShippingDate(LocalDateTime.now().plusDays(PLUS_ONE_WEEK));
        }
        reduceStockItem(itemInDB, createdOrderedItem);
    }

    private BigDecimal setTotalCostOrderedItem(OrderedItem orderedItem) {
        Item itemInDB = itemRepository.getItemByNameAndDescription(orderedItem.getName(), orderedItem.getDescription());
        return itemInDB.getPrice().multiply(BigDecimal.valueOf(orderedItem.getAmountOrdered()));
    }

    private boolean isThereEnoughStock(CreatedOrderedItemDto createdOrderedItem, Item itemInDB) {
        return itemInDB.getStock() > 0 && (itemInDB.getStock() - createdOrderedItem.getAmountOrdered()) > 0;
    }

    private boolean isCreatedOrderItemGivenAmountValid(List<CreatedOrderedItemDto> createdOrderItemList) {
        return createdOrderItemList.stream()
                .allMatch(createdOrderedItem ->
                        NumericValidator.isNotZero(createdOrderedItem.getAmountOrdered()));
    }

    /**
     * Stock can go beneath 0 for resupply
     */
    private void reduceStockItem(Item item, CreatedOrderedItemDto createdOrderedItem) {
        item.setStock(item.getStock() - createdOrderedItem.getAmountOrdered());
    }
}
