-- 02: Insert sample records and retrieve them

USE day11_practice;

INSERT INTO students (student_id, student_name, age, course, email)
VALUES
    (1, 'Kavin', 21, 'CSE', 'kavin@example.com'),
    (2, 'Meena', 20, 'IT', 'meena@example.com');

INSERT INTO employees (employee_id, employee_name, salary, joining_date, email)
VALUES
    (101, 'Ezhil', 500000.00, '2026-02-01', 'ezhil@example.com'),
    (102, 'Sree', 520000.00, '2026-02-02', 'sree@example.com');

-- Read all records
SELECT * FROM students;
SELECT * FROM employees;

-- Select chosen columns
SELECT employee_name, salary FROM employees;

-- Filter and sort results
SELECT * FROM employees WHERE salary > 500000;
SELECT * FROM employees ORDER BY employee_name ASC;
