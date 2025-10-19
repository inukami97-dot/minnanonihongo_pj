// package com.example.minnanonihongo_test_demo.config;

// import com.example.minnanonihongo_test_demo.entity.Lesson;
// import com.example.minnanonihongo_test_demo.repository.LessonRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class DataSeeder {

//     @Bean
//     CommandLineRunner initLessons(LessonRepository lessonRepository) {
//         return args -> {
//             if (lessonRepository.count() == 0) {
//                 Lesson lesson1 = new Lesson();
//                 System.out.println("✅ Đã thêm dữ liệu mẫu cho Lesson!");
//             }
//         };
//     }
// }
