-- Day 12 — Mini Exercises
-- Run after sql_workshop.sql.

-- 1. Find members aged 20 or older.
SELECT * FROM members WHERE age >= 20;

-- 2. Find books with a fee between 20 and 100.
SELECT book_title, fee_amount
FROM loans
WHERE fee_amount BETWEEN 20 AND 100
ORDER BY fee_amount;

-- 3. Count the number of members.
SELECT COUNT(*) AS total_members FROM members;

-- 4. Show sections with at least two loans.
SELECT section_id, COUNT(*) AS total_loans
FROM loans
GROUP BY section_id
HAVING COUNT(*) >= 2;

-- 5. Find members whose email uses example.org.
SELECT * FROM members WHERE email LIKE '%example.org';

-- 6. Calculate the total fees per member, including members with no loans.
SELECT m.member_name, COALESCE(SUM(l.fee_amount), 0) AS total_fees
FROM members AS m
LEFT JOIN loans AS l ON l.member_id = m.member_id
GROUP BY m.member_id, m.member_name;

-- 7. Show sections that currently have no loans.
SELECT s.section_name
FROM library_sections AS s
LEFT JOIN loans AS l ON l.section_id = s.section_id
WHERE l.loan_id IS NULL;

-- 8. Optional: change a fee to test the trigger.
-- UPDATE loans SET fee_amount = 60 WHERE loan_id = 505;
-- SELECT * FROM fee_change_log;
