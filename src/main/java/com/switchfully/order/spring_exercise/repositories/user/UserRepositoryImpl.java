package com.switchfully.order.spring_exercise.repositories.user;

import com.switchfully.order.spring_exercise.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final ConcurrentHashMap<String, User> usersById;

    @Autowired
    public UserRepositoryImpl() {
        usersById = new ConcurrentHashMap<>();
    }

    @Override
    public void save(User user) {
        usersById.put(user.getId(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersById.values());
    }

    @Override
    public User getUserById(String id) {
        return usersById.get(id);
    }
}
