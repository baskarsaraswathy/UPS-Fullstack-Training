# Spring Boot Registration and Login API (Day 24)

This is a Spring Boot REST API demonstrating a structured layered architecture (Controller, Service, Repository, Entity, DTO) to handle user registration and authentication.

## Technologies Used
- Java 21
- Spring Boot 3.2.x
- Spring Data JPA
- MySQL Connector
- Maven



## Database Setup
1. Open MySQL Workbench and create a new database:
   ```sql
   CREATE DATABASE demo;
   ```
2. Open `src/main/resources/application.properties` and verify your MySQL credentials (`spring.datasource.username` and `spring.datasource.password`).
3. By default, `spring.jpa.hibernate.ddl-auto=update` is set. If you are experiencing 500 errors from old schemas, change this temporarily to `create`, run the app once, and then change it back to `update`.

## How to Run
Run `DemoApplication.java` from your IDE (like IntelliJ IDEA). The embedded Tomcat server will start on port `8080`.

## Postman API Testing

### 1. Registration Endpoint
- **Method:** `POST`
- **URL:** `http://localhost:8080/users`
- **Body Type:** raw -> JSON
- **Payload:**
  ```json
  {
    "name": "sanking",
    "email": "sanking@saveetha.com",
    "password": "010203",
    "age": 21
  }
  ```
- **Custom Validation:** Returns `400 Bad Request` with "Error: Email is already registered!" if the email exists, preventing 500 Internal Server Errors.

### 2. Login Endpoint
- **Method:** `POST`
- **URL:** `http://localhost:8080/api/auth/login`
- **Body Type:** raw -> JSON
- **Payload:**
  ```json
  {
    "email": "sanking@saveetha.com",
    "password": "010203"
  }
  ```
- **Custom Validation:** Returns `200 OK` ("Login Successful") or `400 Bad Request` ("Error: Email not found" / "Error: Incorrect password").
