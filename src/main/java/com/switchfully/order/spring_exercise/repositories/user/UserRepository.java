package com.switchfully.order.spring_exercise.repositories.user;

import com.switchfully.order.spring_exercise.domain.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> getAllUsers();
}
