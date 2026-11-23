# 🚀 Day 32: Spring Boot Many-to-Many Relationship & REST APIs

A robust Spring Boot project demonstrating a **Many-to-Many bidirectional relationship** between `Teacher` and `Student` entities, integrated with Bean Validation, MySQL, and Spring Data JPA. Built as part of daily full-stack development coursework.

---

## 🛠️ Tech Stack & Dependencies
* **Java 21**
* **Spring Boot (v4.2.0)**
* **Spring Data JPA** (Hibernate ORM)
* **Spring Web MVC** (REST APIs)
* **Spring Boot Validation** (`@NotBlank`, `@Email`, `@Size`)
* **MySQL Database** / MySQL Connector J

---

## 📂 Project Architecture

```text
com.example.demo
│
├── controller/
│   └── SchoolController.java      # REST endpoints for teachers and students
│
├── entity/
│   ├── Teacher.java               # Owning side with @ManyToMany and @JoinTable
│   └── Student.java               # Inverse side with @ManyToMany and @JsonIgnore
│
├── repository/
│   ├── TeacherRepository.java     # JPA Repository for Teacher
│   └── StudentRepository.java     # JPA Repository for Student
│
└── service/
    └── SchoolService.java         # Business logic & association management
```

---

## ⚙️ Configuration (`application.properties`)

Configure your database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/school_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 API Endpoints & Testing

You can test these endpoints using **Postman**, **cURL**, or **Swagger UI**:

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/teachers` | Create a new teacher |
| **POST** | `/api/students` | Create a new student (with validation) |
| **PUT** | `/api/teachers/{teacherId}/students/{studentId}` | Link/Assign a student to a teacher |
| **GET** | `/api/teachers` | Retrieve all teachers and their assigned students |
| **GET** | `/api/students` | Retrieve all registered students |

### Example JSON Bodies:

* **Create Teacher (`POST /api/teachers`)**
  ```json
  {
    "name": "Dr. Smith",
    "subject": "Mathematics"
  }
  ```

* **Create Student (`POST /api/students`)**
  ```json
  {
    "name": "Alice Johnson",
    "email": "alice@example.com",
    "password": "securepassword123"
  }
  ```

---

## 👨‍💻 Author
**Baskar J**  
Saveetha Engineering College Workspace