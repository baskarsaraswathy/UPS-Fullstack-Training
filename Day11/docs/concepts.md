# Quick Notes: Database Basics

## Database and DBMS
A database is an organized collection of information. A Database Management System (DBMS) is software used to create, maintain, and access that information.

## RDBMS
A Relational DBMS stores information in tables and can connect related tables using keys. For example, an `orders` table can refer to a customer using `customer_id`.

## SQL and NoSQL
- **SQL databases** generally use tables with a defined structure and SQL queries.
- **NoSQL databases** use models such as documents, key-value pairs, graphs, or wide-column records.

## SQL command groups
- **DDL** defines structures: `CREATE`, `ALTER`, `DROP`.
- **DML** changes records: `INSERT`, `UPDATE`, `DELETE`.
- **DQL** retrieves records: `SELECT`.

## Table vocabulary
- **Table:** a collection of related records
- **Row:** one record
- **Column:** one property of a record
- **Primary key:** identifies a row uniquely
- **Foreign key:** refers to a key in another table
- **NOT NULL:** requires a value
- **UNIQUE:** prevents duplicate values in a column or column combination

## Small example
```sql
SELECT item_name, price
FROM items
WHERE price < 100
ORDER BY price ASC;
```
This selects item names and prices below 100, then sorts them from lowest to highest.
