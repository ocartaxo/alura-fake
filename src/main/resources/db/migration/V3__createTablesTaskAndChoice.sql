CREATE TABLE Task(
     id bigint(20) NOT NULL AUTO_INCREMENT,
     task_type enum('OPEN_TEXT', 'SINGLE_CHOICE', 'MULTIPLE_CHOICE') CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci NOT NULL,
     statement varchar(255) NOT NULL,
     task_order int NOT NULL,
     course_id bigint(20) NOT NULL,
     createdAt datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,

     PRIMARY KEY (id),
     CONSTRAINT UC_Course_Statement UNIQUE (course_id, statement),
     CONSTRAINT FK_Activity_Course FOREIGN KEY (course_id) REFERENCES Course(id) ON DELETE CASCADE

)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;


CREATE TABLE Choice(
     id bigint(20) NOT NULL AUTO_INCREMENT,
     choice_option varchar(80) NOT NULL,
     is_correct boolean NOT NULL,
     task_id bigint(20) NOT NULL,
     createdAt datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,

     PRIMARY KEY (id),
     CONSTRAINT FK_Choice_Task FOREIGN KEY (task_id) REFERENCES Task(id) ON DELETE CASCADE,
     CONSTRAINT UQ_Task_Choice UNIQUE (task_id, choice_option)

)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;