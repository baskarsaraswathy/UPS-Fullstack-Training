# Day 34: Spring Security, DTO Validation & JWT Authentication

## 🎯 Objectives
* Implement stateless token-based authentication using **Spring Security 6** and **JJWT (0.12.6)**.
* Secure user passwords using **BCrypt** one-way hashing with random salting.
* Create immutable **DTO records** (`RegisterRequest`, `LoginRequest`, `LoginResponse`, `UserResponse`) backed by **Jakarta Bean Validation** (`@Valid`, `@NotBlank`, `@Email`, `@Size`).
* Configure a custom once-per-request filter (`JwtAuthFilter`) to extract and validate tokens from incoming HTTP headers.
* Establish security filter rules in `SecurityConfig` to protect endpoints while keeping public product catalog and authentication routes accessible.
* Handle authentication and validation exceptions cleanly using `@RestControllerAdvice`.

---

## 🛠️ Key Components Implemented

### 1. DTOs & Validation (`dto/`)
* **`RegisterRequest`**: Validates `fullName`, `email` (`@Email`), and enforces a minimum length of 6 characters for the `password`.
* **`LoginRequest`**: Ensures non-blank credentials for login requests.
* **`LoginResponse` & `UserResponse`**: Immutable Java records that safely transmit auth tokens and user profile data without exposing sensitive fields like password hashes.

### 2. Security Engine (`security/`)
* **`JwtUtil`**: Handles cryptographic key generation (`Keys.hmacShaKeyFor`), JWT token creation with subject/expiration claims, and signature verification.
* **`CustomUserDetailsService`**: Implements Spring Security's `UserDetailsService` to load user records by email from MySQL.
* **`JwtAuthFilter`**: Extends `OncePerRequestFilter` to intercept requests, parse the `Authorization: Bearer <token>` header, validate token signatures, and populate the `SecurityContextHolder`.

### 3. Security Configuration (`config/SecurityConfig.java`)
* Configures **stateless session management** (`SessionCreationPolicy.STATELESS`).
* Disables CSRF (since tokens are passed via HTTP headers rather than cookies) and integrates CORS rules.
* Configures endpoint authorization:
  * **Public URLs (`permitAll`):** `/api/hello`, `/api/users/register`, `/api/users/login`, and `GET` requests on `/api/products/**` and `/api/categories/**`.
  * **Protected URLs (`authenticated`):** All other endpoints require a valid JWT token.

### 4. Global Exception Handling (`exception/GlobalExceptionHandler.java`)
* Catches `BadCredentialsException` and returns a clean `401 Unauthorized` JSON error (`"Invalid email or password"`).
* Catches `MethodArgumentNotValidException` and converts validation constraint violations into a `400 Bad Request` JSON response.

---

## 🚀 Postman Verification Checklist

| Test Case | Method & URL | Body / Headers | Expected Result |
| :--- | :--- | :--- | :--- |
| **1. Public Products** | `GET /api/products` | None | `200 OK` (Public access allowed) |
| **2. Register User** | `POST /api/users/register` | `{"fullName":"Jane Doe", "email":"jane@example.com", "password":"secret123"}` | `201 Created` with user details (no password) |
| **3. Validation Check** | `POST /api/users/register` | `{"fullName":"Jane Doe", "email":"jane2@example.com", "password":"123"}` | `400 Bad Request` (`Password must be at least 6 characters`) |
| **4. Login & Get Token** | `POST /api/users/login` | `{"email":"jane@example.com", "password":"secret123"}` | `200 OK` returning JWT `token` |
| **5. Protected Route (No Token)** | `POST /api/products` | None | `401 Unauthorized` |
| **6. Protected Route (With Token)** | `POST /api/products` | Header: `Authorization: Bearer <your_token>` | `201 Created` |

---

## 💻 Git Commands to Update Repository

Run the following commands in your terminal to commit and push your Day 34 progress:

```bash
git add .
git commit -m "Completed Day 34: Added Spring Security, DTO validation, and JWT authentication"
git push origin main
```