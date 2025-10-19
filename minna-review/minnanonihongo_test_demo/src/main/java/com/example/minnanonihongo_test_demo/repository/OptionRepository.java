package com.example.minnanonihongo_test_demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.minnanonihongo_test_demo.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
    
}
