# Day 13 - JDBC with NetBeans and MySQL

## Topics learned
- What JDBC is and why Java uses it to connect to databases
- MySQL Connector/J (JDBC driver)
- Creating a database and table in MySQL
- Connecting Java to MySQL using `DriverManager`
- Inserting and reading records using `PreparedStatement` and `ResultSet`
- Closing database resources safely with try-with-resources

## Requirements
- JDK
- Apache NetBeans
- MySQL Server running
- MySQL Connector/J JAR

## NetBeans setup
1. Open Apache NetBeans.
2. Create a Java Application named `JDBC_Demo` (or open your existing project).
3. Create a package named `jdbc_demo`.
4. Create a Java class named `JDBC_Demo`.
5. Copy the code from `src/jdbc_demo/JDBC_Demo.java`.
6. Right-click **Libraries** → **Add JAR/Folder...** and select your downloaded `mysql-connector-j-*.jar`.
7. In the Java code, replace `YOUR_MYSQL_PASSWORD` with your own MySQL password.
8. Run the project.

## Database setup
Open MySQL Workbench or the MySQL command line and run the SQL in `sql/day13_setup.sql`.
The script creates the `jdbc_demo` database and a `students` table.

## Expected output
The program connects to MySQL, inserts one sample student, and displays the records in the table.
The inserted record may appear again each time you run the program because this is a simple practice example.

## Important
- Keep your MySQL password private. Do not upload it to GitHub.
- If your MySQL account has no password, set `password` to an empty string: `""`.
- If you get `Access denied`, check your username and password.
- If you get `Communications link failure`, confirm that the `MySQL80` service is running.
