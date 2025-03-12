package com.example.restswaggerdemo.repository;

import com.example.restswaggerdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        // Add some sample users
        User user1 = new User(UUID.randomUUID(), "johndoe", "john@example.com", "John Doe");
        User user2 = new User(UUID.randomUUID(), "janedoe", "jane@example.com", "Jane Doe");

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(users.get(id));
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        users.put(user.getId(), user);
        return user;
    }

    public void deleteById(UUID id) {
        users.remove(id);
    }
}