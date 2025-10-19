package com.example.minnanonihongo_test_demo.controller;

import com.example.minnanonihongo_test_demo.entity.Lesson;
import com.example.minnanonihongo_test_demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // 1️⃣ Danh sách tất cả bài học
    @GetMapping("/lessons")
    public String getAllLessons(Model model) {
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons", lessons);
        return "/lesson/lesson-list"; // lesson-list.html
    }
}
