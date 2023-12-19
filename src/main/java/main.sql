create table students
(
    id             int auto_increment primary key,
    firstName      VARCHAR(255),
    lastName       VARCHAR(255),
    email          VARCHAR(255),
    age            int,
    birthday       date,
    enrollmentDate date,
    gender         VARCHAR(255),
    major          VARCHAR(255),
    average        float,
    address        VARCHAR(255),
    phone          VARCHAR(255)
);

ALTER TABLE Students
    DROP COLUMN major;


CREATE TABLE Majors
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(80),
    abbreviation VARCHAR(10)
);

create table instructors
(
    id         int auto_increment primary key,
    firstName  VARCHAR(50),
    lastName   VARCHAR(50),
    email      VARCHAR(100),
    department VARCHAR(50)
);

create table attendance
(
    id         int auto_increment primary key,
    student_id int          not null,
    course_id  int          not null,
    date       date         not null,
    present    tinyint(1)   not null,
    late       tinyint(1)   null,
    reason     VARCHAR(255) null,
    FOREIGN KEY (student_id) REFERENCES students (id),
    FOREIGN KEY (course_id) REFERENCES courses (id)
);


create table courses
(
    id            int auto_increment
        primary key,
    name          VARCHAR(100) not null,
    instructor_id int          null,
    FOREIGN KEY (instructor_id) REFERENCES instructors (id)
);



