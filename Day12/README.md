# 📘 Day 12 — SQL Skills Workshop

> UPS Fullstack Training | MySQL

## Session focus

This session was about using SQL to keep relational data reliable, answer business questions, and automate a small database task.

## Concepts covered

- Table relationships: primary and foreign keys
- Data rules: `NOT NULL`, `UNIQUE`, `CHECK`, and `DEFAULT`
- Querying records with `WHERE`, `ORDER BY`, `DISTINCT`, and `LIMIT`
- Summarizing information with `COUNT`, `SUM`, `AVG`, `MIN`, and `MAX`
- Group-level filtering using `GROUP BY` and `HAVING`
- Text searches with `LIKE`
- Checking missing values with `IS NULL` and `IS NOT NULL`
- Combining related tables with `LEFT JOIN`
- Automating a record of changes with a trigger

## Repository contents

- `README.md` — session notes
- `sql_workshop.sql` — complete runnable workshop using a library lending database
- `mini_exercises.sql` — extra query practice

## Run it

1. Open MySQL Workbench.
2. Open `sql_workshop.sql`.
3. Execute the script from top to bottom.
4. Review the query results and the change log.
5. Try the extra exercises in `mini_exercises.sql`.

**Warning:** The script drops its own workshop tables before rebuilding them. Use it only in a practice schema.

## Example: find overdue-style high-value loans

```sql
SELECT borrower_name, fee_amount
FROM loans
WHERE fee_amount > 100
ORDER BY fee_amount DESC;
```

## Example: count loans per member

```sql
SELECT m.member_name, COUNT(l.loan_id) AS loan_count
FROM members AS m
LEFT JOIN loans AS l ON l.member_id = m.member_id
GROUP BY m.member_id, m.member_name;
```

## Learning outcome

I practiced enforcing data rules, filtering and sorting records, calculating summaries, grouping results, searching text, checking null values, joining related tables, and creating a trigger for an audit trail.
