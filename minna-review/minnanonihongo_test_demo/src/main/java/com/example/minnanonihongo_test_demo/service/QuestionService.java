package com.example.minnanonihongo_test_demo.service;
import java.util.List;


import com.example.minnanonihongo_test_demo.entity.Question;


public interface QuestionService {
    List<Question> getQuestionsByLesson(Long lessonId);

    boolean checkAnswer(Long questionId, String userAnswer);
}
