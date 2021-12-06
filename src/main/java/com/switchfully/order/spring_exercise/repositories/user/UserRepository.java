package com.switchfully.order.spring_exercise.repositories.user;

import com.switchfully.order.spring_exercise.domain.user.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    List<User> getAllUsers();
}
