-- Day 11: MySQL and SQL Fundamentals
-- Run the statements in order.

CREATE DATABASE IF NOT EXISTS college;
USE college;

CREATE TABLE IF NOT EXISTS students (
    student_id INT,
    student_name VARCHAR(50) NOT NULL,
    age INT,
    dept VARCHAR(50),
    email VARCHAR(50) NOT NULL
);

SELECT * FROM students;

CREATE TABLE IF NOT EXISTS employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100),
    salary DECIMAL(10,2),
    joining_date DATE,
    email VARCHAR(50) UNIQUE
);

INSERT INTO employee
    (employee_id, employee_name, salary, joining_date, email)
VALUES
    (1, 'ezhil', 500000, '2027-02-01', 'ezhil@gmail.com'),
    (2, 'sree', 500000, '2027-02-02', 'sree@gmail.com');

SELECT * FROM employee;

-- This updates every employee because there is no WHERE clause.
UPDATE employee
SET salary = salary + 2000;

SELECT * FROM employee;

SELECT employee_name, salary
FROM employee;

SELECT *
FROM employee
WHERE salary > 500000;

SELECT *
FROM employee
ORDER BY employee_name ASC;

-- Optional table structure practice. Run each statement once.
ALTER TABLE students ADD ph_number VARCHAR(10);
ALTER TABLE students ADD dob DATE;
ALTER TABLE students MODIFY student_name VARCHAR(150) NOT NULL;
ALTER TABLE students RENAME COLUMN dept TO course;
ALTER TABLE students DROP COLUMN ph_number;

DESCRIBE students;
DESCRIBE employee;
