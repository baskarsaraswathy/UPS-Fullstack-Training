# Day 35: Order Management, Transactional Checkout & React Frontend Setup

## 🎯 Objectives
* Implement protected order placement and order history endpoints backed by Spring Security JWT authentication.
* Build relational database entities (`Order` and `OrderItem`) with bi-directional mapping and cascade persistence.
* Enforce ACID transaction management (`@Transactional`) to validate stock availability, deduct inventory, calculate totals securely on the server, and prevent partial writes.
* Initialize the React + Vite frontend (`ecommerce-ui`) and configure an Axios HTTP client with a JWT Bearer token interceptor.

---

## 🛠️ Key Components Implemented

### 1. Order Domain Entities (`model/`)
* **`Order`**: Maps to the `orders` table, linking a `User` (`@ManyToOne`) to a list of `OrderItem` records (`@OneToMany` with `CascadeType.ALL`), tracking `orderDate`, `totalAmount`, and `status`.
* **`OrderItem`**: Maps to the `order_items` table, capturing product snapshots (`quantity` and `unitPrice` at the time of purchase) while preventing infinite JSON recursion via `@JsonIgnore` on the parent `Order` reference.

### 2. Request Validation DTOs (`dto/`)
* **`OrderItemRequest`**: Immutable Java record validating `productId` (`@NotNull`) and enforcing a minimum order quantity of 1 (`@Min(1)`).
* **`OrderRequest`**: Wraps a non-empty list of nested `@Valid OrderItemRequest` items.

### 3. Persistence & Transactional Business Logic (`repository/` & `service/`)
* **`OrderRepository`**: Extends `JpaRepository` with derived query `findByUserEmailOrderByOrderDateDesc(String email)` to retrieve chronological order history for a specific user.
* **`OrderService`**:
  * Annotated with `@Transactional` so stock deductions and order creation succeed or roll back atomically.
  * Fetches real product prices directly from MySQL rather than trusting client-side totals.
  * Validates available inventory before decrementing stock and persisting the final order.

### 4. Protected REST Endpoints (`controller/OrderController.java`)
* **`POST /api/orders`**: Extracts the authenticated user's email from Spring Security's `Authentication` object, places the order, and returns `201 Created`.
* **`GET /api/orders/my`**: Retrieves the complete order history for the currently logged-in user.

### 5. React Frontend Initialization (`ecommerce-ui/`)
* Scaffolded a new React application using Vite and installed `axios` and `react-router-dom@6`.
* Created **`src/services/api.js`** featuring an Axios request interceptor that automatically reads the JWT `token` from `localStorage` and attaches `Authorization: Bearer <token>` to every outgoing API request.
* Configured **`src/main.jsx`** with `BrowserRouter` for client-side routing.

---

## 📂 Project Structure (`com.shop.ecommerce`)

```text
src/main/java/com/shop/ecommerce/
├── config/          # DataSeeder, SecurityConfig, WebConfig
├── controller/      # CategoryController, HelloController, OrderController, ProductController, UserController
├── dto/             # LoginRequest, LoginResponse, OrderItemRequest, OrderRequest, RegisterRequest, UserResponse
├── exception/       # GlobalExceptionHandler, ResourceNotFoundException
├── model/           # Category, Order, OrderItem, Product, User
├── repository/      # CategoryRepository, OrderRepository, ProductRepository, UserRepository
├── security/        # CustomUserDetailsService, JwtAuthFilter, JwtUtil
└── service/         # CategoryService, OrderService, ProductService, UserService