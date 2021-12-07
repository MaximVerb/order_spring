package com.switchfully.order.spring_exercise.services.user;

import java.util.List;

public interface UserService {
    UserDto createUser(CreateUserDto createUserDto);

    List<UserDto> getAllCustomers();

    UserDto getCustomerById(String id);
}
