package com.switchfully.order.spring_exercise.controllers;

import com.switchfully.order.spring_exercise.services.order.CreatedOrderDto;
import com.switchfully.order.spring_exercise.services.order.OrderDto;
import com.switchfully.order.spring_exercise.services.order.OrderReportDto;
import com.switchfully.order.spring_exercise.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(path = "/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderReportDto getOrderByCustomerId(@PathVariable("id") String id) {
        return orderService.getOrderReport(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody CreatedOrderDto createdOrderDto) {
        return orderService.createOrder(createdOrderDto);
    }

    //create recurring order
    @PostMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createRecurringOrder(@PathVariable("id") String orderId) {
        return orderService.createRecurringOrder(orderId);
    }
}
