-- Day 11 practice: Campus Store
-- MySQL 8.4-compatible learning exercise.

CREATE DATABASE IF NOT EXISTS campus_store;
USE campus_store;

CREATE TABLE IF NOT EXISTS categories (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS items (
    item_id INT PRIMARY KEY,
    item_name VARCHAR(80) NOT NULL,
    category_id INT,
    price DECIMAL(8,2) NOT NULL,
    stock_count INT NOT NULL DEFAULT 0,
    CONSTRAINT fk_items_category
        FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

INSERT INTO categories (category_id, category_name)
VALUES
    (1, 'Stationery'),
    (2, 'Accessories'),
    (3, 'Books');

INSERT INTO items (item_id, item_name, category_id, price, stock_count)
VALUES
    (101, 'Notebook', 1, 65.00, 40),
    (102, 'Pen Set', 1, 35.00, 75),
    (103, 'USB Drive', 2, 450.00, 12),
    (104, 'Java Basics', 3, 299.00, 18),
    (105, 'Laptop Sleeve', 2, 799.00, 8);

-- Read the data
SELECT * FROM categories;
SELECT * FROM items;

-- Search and sort
SELECT item_name, price
FROM items
WHERE price < 500
ORDER BY price ASC;

-- Show each item with its category
SELECT i.item_name, c.category_name, i.price
FROM items AS i
JOIN categories AS c
    ON i.category_id = c.category_id;

-- Update one specific item safely
UPDATE items
SET stock_count = stock_count + 5
WHERE item_id = 101;

SELECT item_id, item_name, stock_count
FROM items
WHERE item_id = 101;

-- Table structure practice
ALTER TABLE items ADD description VARCHAR(150);
DESCRIBE items;

-- Optional cleanup: uncomment only if you want to remove the practice database.
-- DROP DATABASE campus_store;
