package com.example.minnanonihongo_test_demo.service;
import java.util.List;
import java.util.Optional;
import com.example.minnanonihongo_test_demo.entity.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    User saveUser(User user);
    void deleteUser(Long id);
}
