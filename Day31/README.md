# 🤝 Lendly — Trust-Driven Peer-to-Peer Rental Marketplace

**Lendly** is a full-stack peer-to-peer (P2P) rental marketplace designed to make borrowing and lending everyday items safe, transparent, and frictionless. Built by **Team DevSync** for the **GEN & Vinsys Capstone**, Lendly solves the core trust barrier in P2P sharing through a secure **Escrow Deposit Engine**, verified user workflows, and real-time lifecycle tracking.

## 📅 Project Milestones & Progress Log

* **Day 31 — Project Presentation (GEN & Vinsys Review):** Successfully delivered the live project presentation via online meeting with the **GEN** and **Vinsys** teams, showcasing Lendly's system architecture, Supabase schema, React/Spring Boot integration, and end-to-end Escrow Deposit Engine workflow.

## 🌟 Key Features

* **🔐 Secure Escrow & Deposit Engine:** Automated security deposit holds upon booking approval, ensuring owners are protected against damage or late returns while guaranteeing fair refunds to renters.
* **📦 Full Rental Lifecycle Management:** Seamless state transitions from listing creation and booking requests to active handover, return verification, and automated deposit settlement.
* **🔍 Smart Discovery & Categorization:** Filter items by category, availability, location, and pricing tiers with instant search capabilities.
* **🛡️ Verified Trust & Reputation System:** Two-way user reviews, verified profile badges, and transparent condition checklists before and after every rental.
* **📊 Interactive User Dashboards:** Dedicated views for **Renters** (active rentals, payment history, saved items) and **Lenders** (inventory management, incoming requests, earnings & escrow status).
* **⚡ Real-Time Notifications & Updates:** Instant status updates on booking approvals, handover reminders, and escrow releases.

## 🏗️ System Architecture & Tech Stack

Lendly follows a decoupled, modern client-server architecture backed by managed cloud database and authentication services:

| Layer | Technology | Purpose |
| :--- | :--- | :--- |
| **Frontend** | React (Vite / TypeScript), Tailwind CSS | Responsive UI, state management, and interactive dashboards |
| **Backend API** | Java 17+, Spring Boot, Spring Security | RESTful APIs, business logic, and escrow state machine |
| **Database & Auth** | Supabase (PostgreSQL, Auth, Storage) | Relational data persistence, Row-Level Security (RLS), and image storage |
| **Build & Tooling** | Maven, npm, Git / GitHub | Dependency management, CI/CD readiness, and version control |

## 🔄 Escrow & Rental Workflow

Lendly enforces a strict state machine to protect both parties throughout the transaction:

1. **Listing & Discovery:** A Lender publishes an item with a daily rental rate and a refundable security deposit amount.
2. **Booking Request:** A Renter selects dates and initiates a booking. The total (`Rental Fee + Security Deposit`) is authorized and held in **Escrow**.
3. **Approval & Handover:** The Lender approves the request. Both parties confirm item condition at pickup (`ACTIVE` state).
4. **Return & Inspection:** Upon return, the Lender inspects the item and confirms safe return (`COMPLETED` state).
5. **Settlement:**
   * **No Issues:** The rental fee is released to the Lender, and 100% of the security deposit is refunded to the Renter.
   * **Damage / Dispute:** Claims are logged with photographic evidence for partial or full deposit deduction.

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed locally:

* **Node.js** (v18+ recommended)
* **Java Development Kit (JDK)** 17 or higher
* **Maven** 3.8+
* A **Supabase** project (for PostgreSQL credentials, API URL, and Anon/Service keys)

### 1. Clone the Repository

```bash
git clone https://github.com/team-devsync/lendly.git
cd lendly
```

### 2. Backend Setup (Spring Boot)

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```
2. Configure your environment variables in `src/main/resources/application.properties` (or via `.env`):
   ```properties
   spring.datasource.url=jdbc:postgresql://<YOUR_SUPABASE_DB_HOST>:5432/postgres
   spring.datasource.username=postgres
   spring.datasource.password=<YOUR_DB_PASSWORD>
   supabase.url=https://<YOUR_PROJECT_ID>.supabase.co
   supabase.key=<YOUR_SUPABASE_SERVICE_ROLE_KEY>
   ```
3. Build and run the Spring Boot server:
   ```bash
   ./mvnw spring-boot:run
   ```
   The API will start on `http://localhost:8080`.

### 3. Frontend Setup (React)

1. Open a new terminal and navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Create a `.env` file in the `frontend` root:
   ```env
   VITE_API_BASE_URL=http://localhost:8080/api
   VITE_SUPABASE_URL=https://<YOUR_PROJECT_ID>.supabase.co
   VITE_SUPABASE_ANON_KEY=<YOUR_SUPABASE_ANON_KEY>
   ```
4. Start the development server:
   ```bash
   npm run dev
   ```
   The application will be available at `http://localhost:5173`.

## 🗄️ Core Database Schema Overview

* **`users`**: User profiles, verification status, contact details, and trust ratings.
* **`items`**: Item metadata, category, daily rate, deposit requirement, availability status, and image URLs.
* **`bookings`**: Links `renter_id` and `item_id`, start/end dates, and current lifecycle status (`PENDING`, `APPROVED`, `ACTIVE`, `RETURNED`, `CANCELLED`).
* **`escrow_transactions`**: Tracks held deposits, rental payouts, refund statuses, and dispute flags.
* **`reviews`**: Post-rental ratings and feedback for both users and items.

## 👥 Team DevSync

Developed with dedication by **Team DevSync** as part of the **GEN & Vinsys** training and capstone program.

* **Architecture, Backend & Escrow Engine:** Team DevSync Engineering
* **Frontend UI/UX & Supabase Integration:** Team DevSync Engineering

## 📄 License

This project is developed for educational and capstone demonstration purposes under the **MIT License**.