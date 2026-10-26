-- Day 12 | Extra Practice Challenges
-- Run after employee_lab.sql.

-- Challenge 1: Find staff aged between 22 and 30.
SELECT *
FROM staff
WHERE age BETWEEN 22 AND 30;

-- Challenge 2: Find the two highest-paid staff members.
SELECT employee_name, monthly_salary
FROM staff
ORDER BY monthly_salary DESC
LIMIT 2;

-- Challenge 3: Show average salary for each assigned team.
SELECT team_id, ROUND(AVG(monthly_salary), 2) AS average_salary
FROM staff
WHERE team_id IS NOT NULL
GROUP BY team_id;

-- Challenge 4: Show teams whose total payroll is above 80000.
SELECT t.team_name, SUM(s.monthly_salary) AS team_payroll
FROM teams AS t
JOIN staff AS s ON s.team_id = t.team_id
GROUP BY t.team_id, t.team_name
HAVING SUM(s.monthly_salary) > 80000;

-- Challenge 5: Find names containing the letter 'a'.
SELECT employee_name
FROM staff
WHERE employee_name LIKE '%a%';

-- Challenge 6: List every team and its number of staff, including zero.
SELECT t.team_name, COUNT(s.staff_id) AS staff_count
FROM teams AS t
LEFT JOIN staff AS s ON s.team_id = t.team_id
GROUP BY t.team_id, t.team_name;

-- Challenge 7: Change one salary and inspect the audit log.
-- UPDATE staff SET monthly_salary = 47000 WHERE staff_id = 202;
-- SELECT * FROM pay_change_log ORDER BY recorded_at DESC;
