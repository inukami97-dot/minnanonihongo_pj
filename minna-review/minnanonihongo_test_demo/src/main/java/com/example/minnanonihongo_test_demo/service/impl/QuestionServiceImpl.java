package com.example.minnanonihongo_test_demo.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.minnanonihongo_test_demo.entity.Question;
import com.example.minnanonihongo_test_demo.repository.QuestionRepository;
import com.example.minnanonihongo_test_demo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestionsByLesson(Long lessonId) {
        return questionRepository.findByLessonId(lessonId);
    }

    @Override
    public boolean checkAnswer(Long questionId, String userAnswer) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question == null) return false;
        return question.getCorrectAnswer().equalsIgnoreCase(userAnswer);
    }
}