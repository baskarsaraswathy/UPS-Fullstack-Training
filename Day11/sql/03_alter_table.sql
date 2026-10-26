-- 03: Practise changing a table structure

USE day11_practice;

ALTER TABLE students ADD date_of_birth DATE;
ALTER TABLE students ADD phone_number VARCHAR(15);

-- Rename a column (MySQL 8.4)
ALTER TABLE students RENAME COLUMN course TO department;

-- Remove a column when it is no longer needed
ALTER TABLE students DROP COLUMN phone_number;

DESCRIBE students;
