package com.example.minnanonihongo_test_demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.minnanonihongo_test_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
} 
    
