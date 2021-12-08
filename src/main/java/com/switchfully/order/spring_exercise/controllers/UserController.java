package com.switchfully.order.spring_exercise.controllers;

import com.switchfully.order.spring_exercise.services.order.OrderReportDto;
import com.switchfully.order.spring_exercise.services.user.CreateUserDto;
import com.switchfully.order.spring_exercise.services.user.UserDto;
import com.switchfully.order.spring_exercise.services.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserDto> getAllCustomers() {
        return userService.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public UserDto getCustomerById(@PathVariable("id") String id) { return userService.getCustomerById(id); }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }


}
