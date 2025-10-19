package com.example.minnanonihongo_test_demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.minnanonihongo_test_demo.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
      List<Question> findByLessonId(Long lessonId);
}
    
