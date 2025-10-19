package com.example.minnanonihongo_test_demo.controller;

import com.example.minnanonihongo_test_demo.entity.Lesson;
import com.example.minnanonihongo_test_demo.entity.Question;
import com.example.minnanonihongo_test_demo.service.LessonService;
import com.example.minnanonihongo_test_demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions/lesson/{lessonId}")
    public String getQuestionsByLesson(@PathVariable("lessonId") Long lessonId, Model model)  {
        Lesson lesson = lessonService.findById(lessonId);
        if (lesson == null) {
            return "redirect:/lessons"; // nếu không tìm thấy bài học
        }

        // Sử dụng service để lấy câu hỏi theo lessonId
        List<Question> questions = questionService.getQuestionsByLesson(lessonId);

        model.addAttribute("lesson", lesson);
        model.addAttribute("questions", questions);
        return "/question/question-list"; // trỏ tới question-list.html
    }
}
