package com.example.minnanonihongo_test_demo.service.impl;
import java.util.List;
import com.example.minnanonihongo_test_demo.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minnanonihongo_test_demo.service.LessonService;


import com.example.minnanonihongo_test_demo.entity.Lesson;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

     @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }
}
