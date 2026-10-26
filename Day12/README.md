# 🚀 UPS Fullstack Training — Day 12

> 💻 Learn daily. Code consistently. Build intelligently.

![Day](https://img.shields.io/badge/Day-12-blue?style=for-the-badge) ![MySQL](https://img.shields.io/badge/MySQL-Database-orange?style=for-the-badge&logo=mysql&logoColor=white) ![SQL](https://img.shields.io/badge/SQL-Advanced-green?style=for-the-badge)

## 🌟 Day 12 Overview

**Topic:** Advanced SQL and Database Operations

Practiced relational database management using MySQL, including table creation, constraints, data retrieval, filtering, sorting, aggregate functions, joins, and triggers.

## 🗄️ 1. Relational Database Creation

Created three tables to manage employee information, department details, and salary change records.

- `department` — Stores department IDs and names.
- `employee` — Stores employee details, salaries, and department references.
- `salary_audit` — Records salary changes for auditing purposes.

## 🛡️ 2. SQL Constraints

| Constraint | Purpose |
|---|---|
| `PRIMARY KEY` | Uniquely identifies each record |
| `NOT NULL` | Prevents missing values |
| `UNIQUE` | Prevents duplicate email addresses |
| `CHECK` | Ensures employee age is at least 18 |
| `DEFAULT` | Assigns a default salary of 30000 |
| `FOREIGN KEY` | Connects employees with departments |

## 🔍 3. Filtering and Sorting Records

### WHERE
```sql
SELECT * FROM employee WHERE age > 21;
```

### ORDER BY
```sql
SELECT * FROM employee ORDER BY name ASC;
SELECT * FROM employee ORDER BY salary DESC;
```

### DISTINCT
```sql
SELECT DISTINCT dept_id FROM employee;
```

### LIMIT
```sql
SELECT * FROM employee LIMIT 3;
```

## 📊 4. Aggregate Functions

```sql
SELECT
    MIN(salary) AS minimum_salary,
    MAX(salary) AS maximum_salary,
    AVG(salary) AS average_salary,
    SUM(salary) AS total_payroll,
    COUNT(*) AS total_employees
FROM employee;
```

Functions covered: `MIN()`, `MAX()`, `AVG()`, `SUM()`, and `COUNT()`.

## 📁 5. GROUP BY and HAVING

```sql
SELECT dept_id, COUNT(*) AS emp_count
FROM employee
WHERE dept_id IS NOT NULL
GROUP BY dept_id
HAVING COUNT(*) > 1;
```

- `GROUP BY` groups records with the same department ID.
- `HAVING` filters groups based on aggregate results.
- `WHERE` filters individual records before grouping.

## 🔎 6. Pattern Matching and NULL Handling

### LIKE
```sql
SELECT * FROM employee WHERE name LIKE 'A%';
SELECT * FROM employee WHERE email LIKE '%gmail%';
```

### IS NULL / IS NOT NULL
```sql
SELECT * FROM employee WHERE dept_id IS NULL;
SELECT * FROM employee WHERE dept_id IS NOT NULL;
```

## 🔗 7. SQL JOIN Operations

Use `LEFT JOIN` to display every department, including departments without employees.

```sql
SELECT
    d.dept_name,
    COUNT(e.id) AS number_of_employees
FROM department d
LEFT JOIN employee e ON d.dept_id = e.dept_id
GROUP BY d.dept_id, d.dept_name;
```

## ⚡ 8. SQL Triggers and Salary Auditing

Created a `salary_audit` table to record salary changes automatically.

```sql
CREATE TABLE salary_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_id INT,
    old_salary DECIMAL(10, 2),
    new_salary DECIMAL(10, 2),
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER trg_salary_update_audit
BEFORE UPDATE ON employee
FOR EACH ROW
BEGIN
    IF OLD.salary <> NEW.salary THEN
        INSERT INTO salary_audit (emp_id, old_salary, new_salary)
        VALUES (OLD.id, OLD.salary, NEW.salary);
    END IF;
END //

DELIMITER ;
```

- `OLD.salary` represents the previous salary.
- `NEW.salary` represents the updated salary.
- The trigger records changes when the salary values compare as unequal.

## 🎯 9. Additional Query Practice

### Employees earning more than 35000
```sql
SELECT id, name, email, age, salary, dept_id
FROM employee
WHERE salary > 35000;
```

### Count employees in each assigned department
```sql
SELECT dept_id, COUNT(*) AS number_of_employees
FROM employee
WHERE dept_id IS NOT NULL
GROUP BY dept_id;
```

## 🏆 Learning Outcomes

- Relational database design and table relationships.
- SQL constraints and data integrity.
- Data insertion, filtering, sorting, and limiting.
- Aggregate functions and grouped queries.
- Pattern matching and NULL handling.
- Department-wise analysis using `LEFT JOIN`.
- Database triggers and salary change auditing.

---

**📅 Day 12 Completed — Advanced SQL and Database Operations**

*Building practical database skills through hands-on MySQL queries.*
