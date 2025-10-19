package com.example.minnanonihongo_test_demo.service;
import java.util.List;
import com.example.minnanonihongo_test_demo.entity.Lesson;


public interface LessonService {
    List<Lesson> findAll();
    Lesson findById(Long id);
}
