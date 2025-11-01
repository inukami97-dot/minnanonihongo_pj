package com.example.minnanonihongo_test_demo.service;

import java.util.List;

import com.example.minnanonihongo_test_demo.entity.Option;

public interface OptionService {
     List<Option> findByQuestionId(Long questionId);
}
