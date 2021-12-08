package com.switchfully.order.spring_exercise.repositories.user;

import com.switchfully.order.spring_exercise.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    List<User> getAllUsers();
    User getUserById(String id);
    Optional<User> findUserByUsername(String username);
    void delete(String id);
    void update(String id, User user);
}
