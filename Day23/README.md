# Teachers Management API

This is a RESTful API built with Spring Boot to manage teacher records. 

## Tech Stack
* **Java:** 21
* **Framework:** Spring Boot 
* **Database:** H2 (In-Memory Database)
* **Build Tool:** Maven

## API Endpoints

### Base URL: `http://localhost:8080/teachers`

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/teachers` | Create a new teacher |
| `GET` | `/teachers` | Retrieve all teachers |
| `GET` | `/teachers/{id}` | Retrieve a specific teacher by ID |
| `PUT` | `/teachers/{id}` | Update an existing teacher completely |
| `PATCH` | `/teachers/{id}` | Update an existing teacher partially |
| `DELETE`| `/teachers/{id}` | Delete a teacher by ID |

## Example JSON Payload
```json
{
    "name": "Aakash",
    "subject": "Java Fullstack"
}
```

## Running the Application
1. Import the project into IntelliJ IDEA, Eclipse, or VS Code.
2. Ensure JDK 21 is configured as the Project SDK.
3. Run `TeachersManagementApplication.java` as a Java Application.
4. The server will start on port 8080.
