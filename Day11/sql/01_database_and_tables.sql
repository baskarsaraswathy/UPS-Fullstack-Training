-- 01: Create a practice database and tables

CREATE DATABASE IF NOT EXISTS day11_practice;
USE day11_practice;

CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(60) NOT NULL,
    age INT,
    course VARCHAR(40),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(80) NOT NULL,
    salary DECIMAL(10, 2),
    joining_date DATE,
    email VARCHAR(100) UNIQUE
);

SHOW TABLES;
DESCRIBE students;
DESCRIBE employees;
