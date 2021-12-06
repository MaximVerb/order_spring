package com.switchfully.order.spring_exercise.controllers;

import com.switchfully.order.spring_exercise.services.order.CreatedOrderDto;
import com.switchfully.order.spring_exercise.services.order.OrderDto;
import com.switchfully.order.spring_exercise.services.order.OrderService;
import com.switchfully.order.spring_exercise.services.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Map<UserDto, List<OrderDto>> getAllOrdersByUser() {
        return orderService.getAllOrdersByUser();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, path = "/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createnAnOrder(@RequestBody CreatedOrderDto createdOrderDto) {
        return orderService.createAnOrder(createdOrderDto);
    }
}
