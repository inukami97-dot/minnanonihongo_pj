CREATE DATABASE minna_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE minna_db;
-- 1️⃣ Tắt foreign key check để drop bảng nếu cần
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

SET FOREIGN_KEY_CHECKS = 1;

-- 2️⃣ Tạo bảng roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- 3️⃣ Tạo bảng users
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE
);

-- 4️⃣ Bảng trung gian user_roles (many-to-many)
CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- 5️⃣ Tạo bảng lessons
CREATE TABLE lessons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(50)
);

-- 6️⃣ Tạo bảng questions
CREATE TABLE questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT,
    question_type VARCHAR(50),
    correct_answer VARCHAR(255),
    lesson_id BIGINT,
    FOREIGN KEY (lesson_id) REFERENCES lessons(id) ON DELETE CASCADE
);

-- 7️⃣ Tạo bảng options
CREATE TABLE options (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    label CHAR(1),
    content VARCHAR(255),
    question_id BIGINT,
    FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE
);

-- 8️⃣ Thêm dữ liệu roles
INSERT INTO roles (id, name) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- 9️⃣ Thêm dữ liệu users với BCrypt password
-- admin: password = 123456
-- user: password = 12345678
INSERT INTO users (id, username, password, enabled) VALUES
(1, 'admin', '$2a$10$EIXhMHpFzS4zRnq5fR9QFeP/Tv2ZBgZioy5v8JnSkavXg/4bGgN7i', true),
(2, 'user', '$2a$10$y6L2cIQfGXYL0vK6bNN1cu70d4uDHmH7XMnE3JqCJ8TbiX7UZC5uG', true);

-- 10️⃣ Gán quyền user_roles
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 2), -- admin có ROLE_ADMIN
(2, 1); -- user có ROLE_USER

-- 11️⃣ Thêm bài học
INSERT INTO lessons (id, name, type) VALUES
(1, 'Bài 1', 'vocab'),
(2, 'Bài 2', 'grammar');

-- 12️⃣ Thêm câu hỏi cho bài 1
INSERT INTO questions (id, content, question_type, correct_answer, lesson_id) VALUES
(1, 'Từ "gakusei" nghĩa là gì?', 'multiple_choice', 'A', 1),
(2, 'Từ "sensei" nghĩa là gì?', 'multiple_choice', 'C', 1);

-- 13️⃣ Thêm option cho câu hỏi 1
INSERT INTO options (label, content, question_id) VALUES
('A', 'Sinh viên', 1),
('B', 'Nhân viên', 1),
('C', 'Giáo viên', 1),
('D', 'Bác sĩ', 1);

-- 14️⃣ Thêm option cho câu hỏi 2
INSERT INTO options (label, content, question_id) VALUES
('A', 'Bác sĩ', 2),
('B', 'Sinh viên', 2),
('C', 'Giáo viên', 2),
('D', 'Nhân viên', 2);




