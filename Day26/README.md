# Student Registration Portal - Full-Stack Application

A lightweight full-stack student portal built with **Java Spring Boot**, **MySQL**, **HTML/JavaScript**, and **React** for training purposes.

---

## 🛠️ Tech Stack
* **Backend:** Java 21, Spring Boot, Spring Data JPA, Hibernate, MySQL Database.
* **Frontend (Basic):** HTML5, Vanilla JavaScript, CSS.
* **Frontend (Advanced/Trainee Focus):** React.js.

---

## 📂 Project Directory Structure
```text
TaskDay26/
│
├── controller/
│   └── AuthController.java       # Handles REST API endpoints (/register, /login, /all-users)
│
├── entity/
│   └── User.java                 # Maps to the MySQL 'users' table
│
├── repository/
│   └── UserRepository.java       # Handles database operations via JpaRepository
│
└── resources/
    └── application.properties    # MySQL database connection configurations
```

---

## 🚀 Key Features & Endpoints
* **`POST /api/auth/register`**: Registers a new student and saves their details to the MySQL database.
* **`POST /api/auth/login`**: Authenticates user credentials against stored database records.
* **`GET /api/auth/get-user/{email}`**: Searches for a specific student email in the database and returns their details.
* **`GET /api/auth/all-users`**: Fetches the complete list of registered students for table population.

---

## 👩‍🏫 Today's Training Sessions Covered
1. **Full-Stack Integration:** Connecting a Java Spring Boot backend REST API with an HTML/JS frontend using the `fetch` API.
2. **Database Persistence & Exception Handling:** Managing duplicate record constraints and rendering dynamic tables instantly upon submission.
3. **React Integration:** Introduction to building modular component-based forms and state management for student registration portals using React.

---

## ⚙️ How to Run
1. **Database:** Create a MySQL database (e.g., `testdb`) and configure your credentials in `application.properties`.
2. **Backend:** Run `TaskDay26Application.java` from IntelliJ IDEA (runs on port `8080`).
3. **Frontend:** Open `index.html` using **Live Server** in VS Code, or launch your React workspace application!