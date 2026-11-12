# Day 25: Spring Boot DTO Mapping with MapStruct

## 📝 Overview
This module demonstrates how to implement the Data Transfer Object (DTO) pattern in a Spring Boot application using **MapStruct**. It abstracts internal database entities from external API payloads, ensuring secure and clean data transfer over REST endpoints.

## 🚀 Key Features Implemented
* **Entity-DTO Separation:** Created distinct `Student` (Database Entity) and `StudentDto` (API Payload) classes.
* **Automated Mapping:** Integrated `mapstruct` and `mapstruct-processor` (v1.5.5.Final) to auto-generate mapping implementation at compile time.
* **Spring Dependency Injection:** Configured MapStruct with `componentModel = "spring"` for seamless `@Autowired` integration in the Service layer.
* **REST API Endpoint:** Built a POST endpoint (`/api/students/add`) to receive DTOs, convert them to Entities, persist to MySQL, and return the saved DTO.

## 🛠️ Tech Stack
* **Java 21**
* **Spring Boot 4.1.2** (Web, Data JPA)
* **MapStruct 1.5.5.Final**
* **MySQL Database**
* **Maven**

## 📂 Project Structure
```text
src/main/java/com/example/demo/
├── controller/
│   └── StudentController.java
├── dto/
│   └── StudentDto.java
├── entity/
│   └── Student.java
├── mapper/
│   └── StudentMap.java
├── repository/
│   └── StudentRepository.java
└── service/
    └── StudentService.java
```

## 🐛 Troubleshooting & Error Resolution
During development, the following challenges were successfully resolved:
1. **[Guice/MissingImplementation] Maven Error:** Resolved by resetting the IntelliJ Maven runner to the bundled version and forcing a clean re-sync of the `.m2` repository.
2. **500 Internal Server Error (DataIntegrityViolationException):** Fixed a `Field 'age' doesn't have a default value` SQL exception by dropping the legacy `student` table in MySQL and allowing Hibernate's `ddl-auto=update` to regenerate the schema to match the current Entity fields.

## 🧪 API Testing (Postman)
**POST** `http://localhost:8080/api/students/add`
```json
// Request Body
{
    "name": "Baskar J",
    "email": "baskar@saveetha.com"
}

// Response (200 OK)
{
    "id": 1,
    "name": "Baskar J",
    "email": "baskar@saveetha.com"
}
```
