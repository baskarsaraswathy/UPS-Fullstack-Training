# 📅 Day 28: Backend Engineering — Core Concepts Revision

Welcome to **Day 28**! Today is dedicated to consolidating and revising essential backend engineering concepts. Whether you are preparing for technical interviews, building a production-ready API, or reviewing system design fundamentals, this guide covers the core pillars of modern backend development.

---

## 📑 Table of Contents
1. [Client-Server Architecture & HTTP](#1-client-server-architecture--http)
2. [RESTful APIs vs. GraphQL vs. gRPC](#2-restful-apis-vs-graphql-vs-grpc)
3. [Databases & Data Modeling](#3-databases--data-modeling)
4. [Authentication & Authorization](#4-authentication--authorization)
5. [Caching Strategies](#5-caching-strategies)
6. [Asynchronous Processing & Message Queues](#6-asynchronous-processing--message-queues)
7. [Security Best Practices](#7-security-best-practices)
8. [Scalability & Deployment Basics](#8-scalability--deployment-basics)
9. [Day 28 Revision Checklist](#9-day-28-revision-checklist)

---

## 1. Client-Server Architecture & HTTP

### Request-Response Lifecycle
1. **DNS Resolution:** Translates domain name to an IP address.
2. **TCP Handshake & TLS:** Establishes a secure connection (HTTPS).
3. **HTTP Request:** Client sends Method, Headers, URL, and optional Body.
4. **Server Processing:** Routing $\rightarrow$ Middleware $\rightarrow$ Controller $\rightarrow$ Service $\rightarrow$ Database.
5. **HTTP Response:** Server returns Status Code, Headers, and Body (JSON/XML/HTML).

### Key HTTP Methods & Idempotency
| Method | Purpose | Idempotent? | Safe? |
| :--- | :--- | :---: | :---: |
| `GET` | Retrieve a resource | ✅ | ✅ |
| `POST` | Create a new resource | ❌ | ❌ |
| `PUT` | Replace an entire resource | ✅ | ❌ |
| `PATCH` | Partially update a resource | ❌* | ❌ |
| `DELETE` | Remove a resource | ✅ | ❌ |

*\*Note: `PATCH` can be designed to be idempotent depending on the implementation.*

### Essential Status Codes
* **2xx (Success):** `200 OK`, `201 Created`, `204 No Content`
* **3xx (Redirection):** `301 Moved Permanently`, `304 Not Modified`
* **4xx (Client Error):** `400 Bad Request`, `401 Unauthorized`, `403 Forbidden`, `404 Not Found`, `429 Too Many Requests`
* **5xx (Server Error):** `500 Internal Server Error`, `502 Bad Gateway`, `503 Service Unavailable`

---

## 2. RESTful APIs vs. GraphQL vs. gRPC

* **REST (Representational State Transfer):**
  * Resource-based URLs (`/api/v1/users/42`).
  * Stateless communication.
  * *Pros:* Simple, cacheable, widely adopted.
  * *Cons:* Over-fetching or under-fetching data.
* **GraphQL:**
  * Single endpoint (`/graphql`), client specifies exact data shape needed.
  * *Pros:* Eliminates over/under-fetching, strongly typed schema.
  * *Cons:* Complex caching, potential for N+1 query issues.
* **gRPC:**
  * Uses HTTP/2 and Protocol Buffers (Protobuf) for binary serialization.
  * *Pros:* Ultra-low latency, ideal for internal microservice-to-microservice communication.
  * *Cons:* Limited direct browser support.

---

## 3. Databases & Data Modeling

### SQL (Relational) vs. NoSQL (Non-Relational)
* **SQL (PostgreSQL, MySQL):** Structured schema, ACID compliant, strong consistency, great for complex joins and financial transactions.
* **NoSQL (MongoDB, Redis, Cassandra):** Flexible schema, horizontal scalability, eventual consistency (BASE), great for unstructured data, real-time analytics, and high-throughput writes.

### ACID Properties
* **A**tomicity: All operations in a transaction succeed, or all fail.
* **C**onsistency: Database moves from one valid state to another.
* **I**solation: Concurrent transactions do not interfere with each other.
* **D**urability: Committed data survives system crashes.

### Performance Tuning
* **Indexing:** Speeds up `SELECT` queries using B-Trees or Hash indexes, at the cost of slower `INSERT`/`UPDATE` operations and extra disk space.
* **N+1 Query Problem:** Executing 1 query to fetch parent records and $N$ additional queries for child records. *Fix:* Use `JOIN`s or eager loading (`include` / `populate`).
* **Connection Pooling:** Reusing active database connections instead of opening a new connection for every request.

---

## 4. Authentication & Authorization

* **Authentication (AuthN):** *Who are you?* (Verifying identity).
* **Authorization (AuthZ):** *What are you allowed to do?* (RBAC - Role-Based Access Control, ABAC - Attribute-Based Access Control).

### Session-Based vs. Token-Based (JWT)
* **Sessions:** Server stores session state in memory/Redis; client holds a `Session ID` in an `HttpOnly` cookie. Easy to revoke immediately.
* **JWT (JSON Web Tokens):** Stateless. Contains `Header.Payload.Signature`.
  * *Best Practice:* Use short-lived **Access Tokens** (e.g., 15 mins) stored in memory, paired with long-lived **Refresh Tokens** stored in `HttpOnly`, `Secure`, `SameSite=Strict` cookies.

---

## 5. Caching Strategies

Caching reduces database load and lowers response latency (commonly using **Redis** or **Memcached**).

1. **Cache-Aside (Lazy Loading):** Application checks cache first. On a cache miss, it reads from the DB, writes to the cache, and returns the data.
2. **Write-Through:** Data is written to the cache and the DB simultaneously. Ensures cache consistency but increases write latency.
3. **Write-Back (Write-Behind):** Data is written to the cache first and asynchronously flushed to the DB later. Fast writes, risk of data loss on crash.

*Eviction Policies:* **LRU** (Least Recently Used), **LFU** (Least Frequently Used), and **TTL** (Time-To-Live).

---

## 6. Asynchronous Processing & Message Queues

Offload heavy, time-consuming tasks (sending emails, video processing, PDF generation) from the main request-response thread.

* **Tools:** RabbitMQ, Apache Kafka, BullMQ (Redis-based), AWS SQS.
* **Key Concepts:**
  * **Producers & Consumers:** Services that publish events and workers that process them.
  * **Dead Letter Queue (DLQ):** Captures messages that fail processing after $N$ retries for manual inspection.
  * **Webhooks:** Event-driven HTTP callbacks sent to external URLs when a specific event occurs.

---

## 7. Security Best Practices

* **Input Validation & Sanitization:** Never trust client input (use libraries like Zod, Joi, or Pydantic).
* **SQL Injection Prevention:** Always use parameterized queries / prepared statements or ORMs.
* **Password Hashing:** Use slow, salted hashing algorithms like **Argon2id** or **bcrypt** (never MD5 or SHA-256).
* **CORS (Cross-Origin Resource Sharing):** Restrict allowed origins, methods, and headers explicitly.
* **Rate Limiting:** Protect APIs against brute-force and DDoS attacks (e.g., Token Bucket or Sliding Window algorithms).
* **Environment Variables:** Store API keys and DB credentials in `.env` files or secret managers—never commit them to Git.

---

## 8. Scalability & Deployment Basics

* **Vertical Scaling (Scale Up):** Adding more CPU/RAM to a single server.
* **Horizontal Scaling (Scale Out):** Adding more server instances behind a **Load Balancer** (Nginx, AWS ALB) using Round-Robin or Least-Connections routing.
* **Stateless Services:** Store user state in external stores (Redis/DB) rather than local server memory so any instance can handle any request.
* **Containerization:** Package applications and dependencies using **Docker** for consistent environments across dev, staging, and production.

---

## 9. Day 28 Revision Checklist

- [ ] Can I explain the full lifecycle of an HTTP request?
- [ ] Do I know when to choose SQL vs. NoSQL?
- [ ] Can I implement JWT authentication with refresh token rotation?
- [ ] Have I practiced writing parameterized queries and validating inputs?
- [ ] Do I understand how to resolve an N+1 query bottleneck?
- [ ] Can I design a basic Cache-Aside flow with Redis?