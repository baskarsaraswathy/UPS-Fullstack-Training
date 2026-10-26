# Day 12 | Advanced SQL Lab

> UPS Fullstack Training · MySQL practice

## What I practiced

This lab explores how relational tables work together and how SQL can validate, inspect, summarize, and audit data.

### Topics
- Relational tables and foreign-key relationships
- `PRIMARY KEY`, `FOREIGN KEY`, `NOT NULL`, `UNIQUE`, `CHECK`, and `DEFAULT`
- Filtering with `WHERE`, ordering with `ORDER BY`, and limiting output with `LIMIT`
- Unique values with `DISTINCT`
- Group summaries with `GROUP BY` and `HAVING`
- `COUNT`, `SUM`, `AVG`, `MIN`, and `MAX`
- Pattern matching with `LIKE`
- Missing-value checks with `IS NULL` and `IS NOT NULL`
- Department summaries using `LEFT JOIN`
- A trigger that writes salary changes to an audit table

## Files

- `employee_lab.sql` — creates the database tables, adds example records, and runs the demonstrations.
- `challenge_queries.sql` — additional practice prompts with example solutions.

## Run the lab

1. Open MySQL Workbench and connect to your local MySQL server.
2. Open `employee_lab.sql`.
3. Execute the script from top to bottom.
4. Review each result grid and the `salary_audit` table.
5. Open `challenge_queries.sql` for extra practice.

> **Note:** The setup script drops the lab tables before recreating them. Do not run it against tables containing data you need to keep.

## Query examples

### Find employees above a salary threshold
```sql
SELECT employee_name, monthly_salary
FROM staff
WHERE monthly_salary > 40000
ORDER BY monthly_salary DESC;
```

### Summarize headcount by team
```sql
SELECT team_id, COUNT(*) AS team_size
FROM staff
WHERE team_id IS NOT NULL
GROUP BY team_id
HAVING COUNT(*) >= 2;
```

### Include teams with no staff
```sql
SELECT t.team_name, COUNT(s.staff_id) AS team_size
FROM teams AS t
LEFT JOIN staff AS s ON s.team_id = t.team_id
GROUP BY t.team_id, t.team_name;
```

## Learning result

I practiced using constraints to protect data quality, clauses to retrieve relevant records, aggregates to summarize information, joins to combine related tables, and triggers to keep a basic audit trail.
