-- Tabela users
CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       registration_number VARCHAR(50) UNIQUE, -- Campo de matrícula opcional
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                       updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela events
CREATE TABLE events (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        location VARCHAR(255),
                        event_date DATETIME,
                        created_by BIGINT,
                        FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela institutions
CREATE TABLE institutions (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              user_id BIGINT,
                              street VARCHAR(30),
                              neighborhood VARCHAR(30),
                              postal_code VARCHAR(30),
                              number VARCHAR(30),
                              additional_info VARCHAR(30),
                              city VARCHAR(30),
                              state VARCHAR(30),
                              phone VARCHAR(11),
                              FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela teachers
CREATE TABLE teachers (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          user_id BIGINT,
                          institution_id BIGINT,
                          campus varchar(50),
                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                          FOREIGN KEY (institution_id) REFERENCES institutions(id) ON DELETE CASCADE
);

-- Tabela students
CREATE TABLE students (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          user_id BIGINT,
                          course VARCHAR(50),
                          campus varchar(50),
                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela enrollments
CREATE TABLE enrollments (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             student_id BIGINT,
                             event_id BIGINT,
                             enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
                             FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

INSERT INTO users (name, email, registration_number, password, role) VALUES
('Admin User', 'admin@example.com', 'ADM001', '$2y$10$HGnQkO0QS4ICIVBDFmbl0OGtqXvVEH3VkMIPpnWboBQwQiTYUMOvW', 'ADM'),
('Teacher User', 'teacher@example.com', 'TEA001', '$2y$10$HGnQkO0QS4ICIVBDFmbl0OGtqXvVEH3VkMIPpnWboBQwQiTYUMOvW', 'TEACHER'),
('Student User', 'student@example.com', 'STU001', '$2y$10$HGnQkO0QS4ICIVBDFmbl0OGtqXvVEH3VkMIPpnWboBQwQiTYUMOvW', 'STUDENT'),
('Institution User', 'institution@example.com', 'INS001', '$2y$10$HGnQkO0QS4ICIVBDFmbl0OGtqXvVEH3VkMIPpnWboBQwQiTYUMOvW', 'INSTITUTE');

-- Populando a tabela institutions
INSERT INTO institutions (user_id, street, neighborhood, postal_code, number, additional_info, city, state, phone) VALUES
(4, '123 Main St', 'Downtown', '12345678', '100', 'Building A', 'Sample City', 'SC', '98765432100');

-- Populando a tabela teachers
INSERT INTO teachers (user_id, institution_id, campus) VALUES
(2, 1, 'Main Campus');

-- Populando a tabela students
INSERT INTO students (user_id, course, campus) VALUES
(3, 'Computer Science', 'Tech Campus');

-- Populando a tabela events
INSERT INTO events (title, description, location, event_date, created_by) VALUES
('Tech Conference', 'A conference about the latest in tech.', 'Tech Hall', '2024-12-01 10:00:00', 1),
('Science Fair', 'Annual science fair for students.', 'Community Center', '2024-12-15 09:00:00', 1);

-- Populando a tabela enrollments
INSERT INTO enrollments (student_id, event_id, enrollment_date) VALUES
(1, 1, CURRENT_TIMESTAMP),
(1, 2, CURRENT_TIMESTAMP);

