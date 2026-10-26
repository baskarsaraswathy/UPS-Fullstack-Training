# Day 11 – MySQL and SQL Fundamentals

![Day](https://img.shields.io/badge/Day-11-blue?style=for-the-badge)
![Database](https://img.shields.io/badge/Database-MySQL-orange?style=for-the-badge&logo=mysql&logoColor=white)
![Language](https://img.shields.io/badge/Language-SQL-lightgrey?style=for-the-badge)

**Training:** UPS Java Full Stack Training  
**Day:** 11  
**Focus:** MySQL, Database Fundamentals, DDL, DML, DQL, and Table Operations

---

## 1. Overview

Day 11 focused on database fundamentals and SQL commands. Practised creating databases and tables, modifying table structures, inserting employee records, retrieving data, and updating existing records.

## 2. Database Fundamentals

| Topic | Description |
|---|---|
| Data vs Database | Individual facts versus organized data |
| Server | A system that provides services to clients |
| SQL vs NoSQL | Relational databases versus other data models |
| DBMS vs RDBMS | Database management systems and relational database systems |

## 3. SQL Command Categories

### DDL – Data Definition Language

Used to define or change database structures.

| Command | Description |
|---|---|
| `CREATE` | Creates a database or table |
| `ALTER` | Changes an existing table structure |
| `DROP` | Removes a database object |
| `TRUNCATE` | Removes all rows from a table |

### DML – Data Manipulation Language

Used to add, change, or remove records.

| Command | Description |
|---|---|
| `INSERT` | Adds records |
| `UPDATE` | Changes existing records |
| `DELETE` | Removes records |

### DQL – Data Query Language

| Command | Description |
|---|---|
| `SELECT` | Retrieves records from a table |

## 4. Practical Exercises

### Task 1 – Create a College Database and Students Table

```sql
CREATE DATABASE college;
USE college;

CREATE TABLE students (
    student_id INT,
    student_name VARCHAR(50) NOT NULL,
    age INT,
    dept VARCHAR(50),
    email VARCHAR(50) NOT NULL
);

SELECT * FROM students;
```

**Learning outcome:** Created a database and table, defined columns, and used `NOT NULL` to require student names and email addresses.

### Task 2 – Create an Employee Table

```sql
CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100),
    salary DECIMAL(10,2),
    joining_date DATE,
    email VARCHAR(50) UNIQUE
);

SELECT * FROM employee;
```

**Learning outcome:** Practised SQL data types, `PRIMARY KEY`, and `UNIQUE`.

### Task 3 – Alter the Students Table

```sql
ALTER TABLE students
ADD ph_number VARCHAR(10);

ALTER TABLE students
ADD dob DATE,
MODIFY student_name VARCHAR(150) NOT NULL,
RENAME COLUMN dept TO course,
DROP COLUMN ph_number;

DESCRIBE students;
DESCRIBE employee;
```

**Learning outcome:**

- `ADD` adds a column.
- `MODIFY` changes a column definition.
- `RENAME COLUMN` changes a column name.
- `DROP COLUMN` removes a column.
- `DESCRIBE` displays the table structure.

### Task 4 – Insert Employee Records

```sql
INSERT INTO employee
    (employee_id, employee_name, salary, joining_date, email)
VALUES
    (1, 'ezhil', 500000, '2027-02-01', 'ezhil@gmail.com'),
    (2, 'sree', 500000, '2027-02-02', 'sree@gmail.com');

SELECT * FROM employee;
```

**Learning outcome:** Inserted multiple records with one `INSERT INTO` statement.

### Task 5 – Increment Employee Salaries

```sql
UPDATE employee
SET salary = salary + 2000;

SELECT * FROM employee;
```

**Important:** This query increases the salary of **every employee** because it does not contain a `WHERE` clause. In real applications, check the target records before running an update.

### Task 6 – Retrieve and Filter Records

```sql
SELECT * FROM employee;

SELECT employee_name, salary
FROM employee;

SELECT *
FROM employee
WHERE salary > 500000;

SELECT *
FROM employee
ORDER BY employee_name ASC;
```

**Learning outcome:** Used `SELECT`, `WHERE`, and `ORDER BY` to retrieve, filter, and sort records.

## 5. Key Learnings

- Understood database fundamentals, DBMS, RDBMS, SQL, and NoSQL.
- Learned DDL, DML, and DQL commands.
- Created databases and tables.
- Practised data types and constraints.
- Inserted and retrieved records.
- Updated records using arithmetic expressions.
- Modified table structures with `ALTER TABLE`.
- Used `WHERE` to filter and `ORDER BY` to sort records.

## 6. Tools

- MySQL Server 8.4 LTS
- SQL command line / MySQL Workbench, depending on the environment used

> Note: If you practised in the XAMPP terminal shown during training, it may be running MariaDB. MariaDB is MySQL-compatible but is a separate database server. Use the tool name that matches your actual practice environment.

---

**Training:** UPS Java Full Stack Training  
**Day:** 11  
**Focus:** MySQL and SQL Fundamentals
