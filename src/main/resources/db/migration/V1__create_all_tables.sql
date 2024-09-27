-- Tabela users
CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
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
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        location VARCHAR(255),
                        event_date DATETIME,
                        created_by INT,
                        FOREIGN KEY (created_by) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela institutions
CREATE TABLE institutions (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              user_id INT,
                              address VARCHAR(100),
                              phone VARCHAR(11),
                              FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela teachers
CREATE TABLE teachers (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id INT,
                          institution_id INT,
                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                          FOREIGN KEY (institution_id) REFERENCES institutions(id) ON DELETE CASCADE
);

-- Tabela students
CREATE TABLE students (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          user_id INT,
                          course VARCHAR(50),
                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela enrollments
CREATE TABLE enrollments (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             student_id INT,
                             event_id INT,
                             enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
                             FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);
