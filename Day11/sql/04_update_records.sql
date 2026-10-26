-- 04: Update selected records
-- Always use a WHERE clause when you intend to change specific rows.

USE day11_practice;

-- Increase one employee's salary by 2,000
UPDATE employees
SET salary = salary + 2000
WHERE employee_id = 101;

SELECT employee_id, employee_name, salary
FROM employees
WHERE employee_id = 101;

-- Example of deleting one specific practice record (optional):
-- DELETE FROM students WHERE student_id = 2;
