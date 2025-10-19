package com.example.minnanonihongo_test_demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;   // A, B, C, D
    private String content; // Nội dung lựa chọn

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // getters và setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
