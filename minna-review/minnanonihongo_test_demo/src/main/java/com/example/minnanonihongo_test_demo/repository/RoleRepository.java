package com.example.minnanonihongo_test_demo.repository;

import com.example.minnanonihongo_test_demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
    // Phương thức để tìm vai trò dựa trên tên (ROLE_ADMIN, ROLE_USER)
    Optional<Role> findByName(String name);
}