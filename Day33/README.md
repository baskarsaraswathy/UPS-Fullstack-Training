# 🚀 Day 33: Spring Boot — Global Exception Handling, Pagination & JPQL

Welcome to **Day 33** of my Spring Boot learning journey! Today's focus was on building resilient REST APIs using centralized exception handling, managing large datasets efficiently with pagination, and writing custom database queries with JPQL.

---

## 📚 Topics Covered

1. **Global Exception Handling (`@RestControllerAdvice`)**
2. **Standardized Error Responses (`ErrorResponse` DTO)**
3. **Pagination (`Pageable` & `PageRequest`)**
4. **JPQL (Java Persistence Query Language)**

---

## 🛠️ Detailed Breakdown & Code Snippets

### 1. Global Exception Handling
Using `@RestControllerAdvice` and `@ExceptionHandler`, we can intercept exceptions across the entire application and return clean, consistent HTTP status codes and error messages instead of raw stack traces.

* **`MethodArgumentNotValidException` (`400 Bad Request`):** Captures bean validation (`@Valid`) field errors.
* **`StudentNotFoundException` (`404 Not Found`):** Custom exception for missing records.
* **`EmailAlreadyExistsException` (`409 Conflict`):** Custom exception for duplicate entries.
* **`Exception` (`500 Internal Server Error`):** Fallback handler for unexpected server errors.

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                errors
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Student Not Found",
                errors
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmail(EmailAlreadyExistsException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("email", ex.getMessage());

        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Duplicate Email",
                errors
        );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "An unexpected error occurred");

        ErrorResponse response = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                errors
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

---

### 2. Standardized Error Response Model
A custom `ErrorResponse` class ensures every API error returns a predictable JSON payload containing a timestamp, HTTP status code, error title, and a map of specific error messages.

```java
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Map<String, String> messages;

    public ErrorResponse(int status, String error, Map<String, String> messages) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.messages = messages;
    }

    // Getters
    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public Map<String, String> getMessages() { return messages; }
}
```

**Sample JSON Output (`400 Bad Request`):**
```json
{
  "timestamp": "2026-11-25T13:15:30.123",
  "status": 400,
  "error": "Validation Failed",
  "messages": {
    "email": "Must be a well-formed email address"
  }
}
```

---

### 3. Pagination with Spring Data JPA
Instead of fetching thousands of records at once, `Pageable` and `PageRequest` allow us to retrieve data in chunks (`Page<T>`), improving performance and network efficiency.

```java
@GetMapping("/teacher/page")
public Page<Teacher> getTeachers() {
    // PageRequest.of(pageNumber, pageSize) -> 0-indexed page number
    Pageable pageable = PageRequest.of(1, 1);
    return repo.findAll(pageable);
}
```
* **`PageRequest.of(1, 1)`**: Fetches the **2nd page** (index `1`) with **1 record** per page.
* **`Page<Teacher>`**: Automatically includes metadata such as `totalElements`, `totalPages`, `size`, `number`, and `content`.

---

### 4. JPQL (Java Persistence Query Language)
Explored writing object-oriented queries using `@Query` in Spring Data JPA repositories to query entity objects and their fields directly rather than raw database table/column names.

```java
// Example JPQL usage in Repository
@Query("SELECT t FROM Teacher t WHERE t.department = :dept")
List<Teacher> findTeachersByDepartment(@Param("dept") String department);
```

---

## 🎯 Key Takeaways
* Centralizing exceptions keeps controllers clean and avoids repetitive `try-catch` blocks.
* Pagination is essential for scalable REST APIs and pairs seamlessly with Spring Data's `JpaRepository`.
* JPQL abstracts away database-specific SQL dialects by operating directly on Java entity models.