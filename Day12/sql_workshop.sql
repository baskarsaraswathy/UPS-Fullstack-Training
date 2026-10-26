-- Day 12 — SQL Skills Workshop
-- Scenario: library lending database
-- MySQL 8+. Run only in a practice schema.

DROP TABLE IF EXISTS fee_change_log;
DROP TABLE IF EXISTS loans;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS library_sections;

CREATE TABLE library_sections (
    section_id INT PRIMARY KEY,
    section_name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE members (
    member_id INT PRIMARY KEY,
    member_name VARCHAR(80) NOT NULL,
    email VARCHAR(120) UNIQUE,
    age INT CHECK (age >= 16),
    membership_status VARCHAR(20) NOT NULL DEFAULT 'Active'
);

CREATE TABLE loans (
    loan_id INT PRIMARY KEY,
    book_title VARCHAR(120) NOT NULL,
    fee_amount DECIMAL(8,2) NOT NULL DEFAULT 0.00,
    member_id INT,
    section_id INT,
    CONSTRAINT fk_loan_member
        FOREIGN KEY (member_id) REFERENCES members(member_id),
    CONSTRAINT fk_loan_section
        FOREIGN KEY (section_id) REFERENCES library_sections(section_id)
);

INSERT INTO library_sections VALUES
(1, 'Technology'),
(2, 'Literature'),
(3, 'Science'),
(4, 'History'),
(5, 'Arts');

INSERT INTO members (member_id, member_name, email, age) VALUES
(301, 'Ananya Bose', 'ananya@example.org', 21),
(302, 'Dev Patel', 'dev@example.org', 28),
(303, 'Harini Kumar', 'harini@example.org', 19),
(304, 'Irfan Ali', 'irfan@example.org', 33),
(305, 'Janani Rao', 'janani@example.org', 24);

INSERT INTO loans (loan_id, book_title, fee_amount, member_id, section_id) VALUES
(501, 'Learning SQL', 120.00, 301, 1),
(502, 'Modern Poetry', 0.00, 302, 2),
(503, 'Space and Time', 45.50, 301, 3),
(504, 'World History', 110.00, 303, 4),
(505, 'Design Basics', 25.00, 304, 5),
(506, 'Database Systems', 75.00, 302, 1),
(507, 'Short Stories', 0.00, 305, 2);

-- A. Filter rows and sort the results
SELECT * FROM members WHERE age >= 21;
SELECT * FROM loans ORDER BY fee_amount DESC;
SELECT * FROM loans ORDER BY book_title ASC;

-- B. Return unique section IDs and a small sample
SELECT DISTINCT section_id FROM loans;
SELECT * FROM loans LIMIT 4;

-- C. Aggregate fee statistics
SELECT
    COUNT(*) AS loan_count,
    SUM(fee_amount) AS fees_total,
    AVG(fee_amount) AS average_fee,
    MIN(fee_amount) AS smallest_fee,
    MAX(fee_amount) AS largest_fee
FROM loans;

-- D. Group loans by section and keep groups with multiple loans
SELECT section_id, COUNT(*) AS section_loan_count
FROM loans
GROUP BY section_id
HAVING COUNT(*) > 1;

-- E. Pattern matching
SELECT * FROM members WHERE member_name LIKE 'A%';
SELECT * FROM loans WHERE book_title LIKE '%SQL%';

-- F. NULL checks
SELECT * FROM loans WHERE member_id IS NULL;
SELECT * FROM loans WHERE section_id IS NOT NULL;

-- G. Find fees above a threshold
SELECT loan_id, book_title, fee_amount
FROM loans
WHERE fee_amount > 50
ORDER BY fee_amount DESC;

-- H. LEFT JOIN: show every member, including members with no loans
SELECT m.member_name, COUNT(l.loan_id) AS loan_count
FROM members AS m
LEFT JOIN loans AS l ON l.member_id = m.member_id
GROUP BY m.member_id, m.member_name
ORDER BY m.member_name;

-- I. LEFT JOIN: show every section, including sections with no loans
SELECT s.section_name, COUNT(l.loan_id) AS loan_count
FROM library_sections AS s
LEFT JOIN loans AS l ON l.section_id = s.section_id
GROUP BY s.section_id, s.section_name
ORDER BY s.section_name;

-- J. Audit changes to loan fees
CREATE TABLE fee_change_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    loan_id INT NOT NULL,
    old_fee DECIMAL(8,2),
    new_fee DECIMAL(8,2),
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER trg_log_fee_update
BEFORE UPDATE ON loans
FOR EACH ROW
BEGIN
    IF NOT (OLD.fee_amount <=> NEW.fee_amount) THEN
        INSERT INTO fee_change_log (loan_id, old_fee, new_fee)
        VALUES (OLD.loan_id, OLD.fee_amount, NEW.fee_amount);
    END IF;
END //

DELIMITER ;

-- Optional trigger test:
-- UPDATE loans SET fee_amount = 130.00 WHERE loan_id = 501;
-- SELECT * FROM fee_change_log;
