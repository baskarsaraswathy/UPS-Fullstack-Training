-- Day 12 | Advanced SQL Lab
-- MySQL 8+
-- This script drops and recreates only the lab tables.

DROP TABLE IF EXISTS pay_change_log;
DROP TABLE IF EXISTS staff;
DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
    team_id INT PRIMARY KEY,
    team_name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE staff (
    staff_id INT PRIMARY KEY,
    employee_name VARCHAR(80) NOT NULL,
    work_email VARCHAR(120) UNIQUE,
    age INT CHECK (age >= 18),
    monthly_salary DECIMAL(10, 2) NOT NULL DEFAULT 30000.00,
    team_id INT,
    CONSTRAINT fk_staff_team
        FOREIGN KEY (team_id) REFERENCES teams(team_id)
);

INSERT INTO teams (team_id, team_name) VALUES
(10, 'Platform'),
(20, 'People Operations'),
(30, 'Accounting'),
(40, 'Customer Success'),
(50, 'Research');

INSERT INTO staff
    (staff_id, employee_name, work_email, age, monthly_salary, team_id)
VALUES
(201, 'Meera Iyer', 'meera.iyer@example.com', 27, 62000.00, 10),
(202, 'Naveen Das', 'naveen.das@example.com', 24, 45500.00, 10),
(203, 'Farah Khan', 'farah.khan@example.com', 31, 51000.00, 20),
(204, 'Karthik Raj', 'karthik.raj@example.com', 29, 39500.00, 30),
(205, 'Leela Menon', 'leela.menon@example.com', 23, 33500.00, 20),
(206, 'Omar Joseph', 'omar.joseph@example.com', 26, 42000.00, 10),
(207, 'Priya Nair', 'priya.nair@example.com', 22, DEFAULT, 40),
(208, 'Ravi Shankar', 'ravi.shankar@example.com', 34, 72000.00, NULL);

-- 1. Filter records
SELECT *
FROM staff
WHERE age >= 25;

-- 2. Sort by employee name
SELECT staff_id, employee_name, monthly_salary
FROM staff
ORDER BY employee_name ASC;

-- 3. Find the distinct team IDs (NULL may appear as a distinct result)
SELECT DISTINCT team_id
FROM staff;

-- 4. Return a small sample
SELECT *
FROM staff
LIMIT 4;

-- 5. Count teams with at least two staff members
SELECT team_id, COUNT(*) AS team_size
FROM staff
WHERE team_id IS NOT NULL
GROUP BY team_id
HAVING COUNT(*) >= 2;

-- 6. Calculate salary statistics
SELECT
    MIN(monthly_salary) AS lowest_salary,
    MAX(monthly_salary) AS highest_salary,
    ROUND(AVG(monthly_salary), 2) AS average_salary,
    SUM(monthly_salary) AS salary_total,
    COUNT(*) AS staff_count
FROM staff;

-- 7. Pattern matching
SELECT *
FROM staff
WHERE employee_name LIKE 'M%';

SELECT *
FROM staff
WHERE work_email LIKE '%example.com';

-- 8. Check missing team assignments
SELECT *
FROM staff
WHERE team_id IS NULL;

SELECT *
FROM staff
WHERE team_id IS NOT NULL;

-- 9. Staff above a salary threshold
SELECT staff_id, employee_name, monthly_salary, team_id
FROM staff
WHERE monthly_salary > 40000.00;

-- 10. Salary ranking, highest first
SELECT staff_id, employee_name, monthly_salary
FROM staff
ORDER BY monthly_salary DESC;

-- 11. Team headcount, excluding unassigned staff
SELECT team_id, COUNT(*) AS staff_count
FROM staff
WHERE team_id IS NOT NULL
GROUP BY team_id;

-- 12. Keep all teams in the output, even if no one belongs to them
SELECT t.team_name, COUNT(s.staff_id) AS staff_count
FROM teams AS t
LEFT JOIN staff AS s ON s.team_id = t.team_id
GROUP BY t.team_id, t.team_name
ORDER BY t.team_name;

-- 13. Salary change audit table
CREATE TABLE pay_change_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    staff_id INT NOT NULL,
    previous_salary DECIMAL(10, 2),
    revised_salary DECIMAL(10, 2),
    recorded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER audit_staff_salary
BEFORE UPDATE ON staff
FOR EACH ROW
BEGIN
    IF NOT (OLD.monthly_salary <=> NEW.monthly_salary) THEN
        INSERT INTO pay_change_log
            (staff_id, previous_salary, revised_salary)
        VALUES
            (OLD.staff_id, OLD.monthly_salary, NEW.monthly_salary);
    END IF;
END //

DELIMITER ;

-- 14. Optional trigger test (uncomment to run)
-- UPDATE staff
-- SET monthly_salary = 65000.00
-- WHERE staff_id = 201;
--
-- SELECT * FROM pay_change_log;
