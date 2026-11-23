# 🛠️ LENDLY — Community-Based Tool & Equipment Rental Platform

> **Safer, Smarter Hyperlocal Equipment Rentals**
>
> **Team DevSync:** Iyalarasu C · Dharmalingam S · Baskar J  
> **Institution:** Saveetha Engineering College · **GIF 2026**  
> **Status:** 📅 **Day 30 Milestone** — 6+1 Pitch Deck Finalized & Presentation Ready

---

## 📌 Project Overview

**LENDLY** is a hyperlocal peer-to-peer (P2P) equipment and tool rental platform that connects verified neighbors within a **`< 5 km` radius** to share underused tools safely. By combining task-based discovery, QR code handovers, timestamped photo condition logs, and a trust-scored UPI escrow mechanism, LENDLY eliminates expensive one-time tool purchases while protecting owners against theft and damage.

---

## 🎯 Problem & Solution Summary

### The Problem
* **Underused Assets:** Expensive tools sit idle in homes after brief use.
* **High Purchase Cost:** One-time tasks force individuals into costly full purchases.
* **Trust & Damage Risk:** Unverified borrowers raise safety and damage concerns for owners.

### The LENDLY Solution
* **🔍 Task-Based Discovery:** Search and filter available tools within a 5 km neighborhood radius by project category.
* **📲 QR Handover & Photo Logs:** Dual QR check-out/return verification paired with mandatory pre- and post-rental timestamped condition photos.
* **⚖️ Dynamic Trust Deposits:** A 100-point reputation engine scales required security deposits—rewarding reliable users with lower upfront holds.
* **⚡ Secure UPI & Direct Exchange:** Instant UPI escrow locks funds during the rental and releases them automatically upon verified return.

---

## 🧩 Six Integrated Application Modules

| Module | Name | Core Functionality |
| :--- | :--- | :--- |
| **01** | **Sign In & Auth** | OTP verification and session management with Supabase JWT. |
| **02** | **Task-Based Search** | Geo-filtered discovery engine showing tools within 5 km. |
| **03** | **Booking & Handover** | Dynamic deposit calculation, UPI escrow lock, and QR check-out. |
| **04** | **Condition Verification** | Pre/post-rental photo logs and structured dispute resolution. |
| **05** | **Trust & Reputation** | 100-point trust score (`History: 50`, `Condition: 25`, `Reviews: 25`) and badges. |
| **06** | **Analytics & Reporting** | User rental metrics, earnings tracking, and downloadable PDF reports. |

---

## 🔄 Five-Step Rental Lifecycle

```text
[1. Discover] ──▶ [2. Book & Escrow] ──▶ [3. QR Handover] ──▶ [4. Return Check] ──▶ [5. Release & Rate]
```

1. **Discover:** Filter nearby tools by project task (`< 5 km`).
2. **Book & Escrow:** Pay rental fee and trust-adjusted UPI security deposit.
3. **QR Handover:** Scan peer QR code and upload pre-rental condition photos.
4. **Return Check:** Scan QR upon return and verify post-rental condition photos.
5. **Release & Rate:** Refund security deposit from escrow and update trust scores.

---

## 🛠️ Full-Stack Technology Architecture

* **Frontend:** React & Vite (JavaScript, Responsive CSS)
* **Backend:** Java Spring Boot (Stateless REST APIs, Geo-Query Engine, Escrow Workflows)
* **Database & Storage:** PostgreSQL & Media Buckets (Managed via Supabase)
* **Security:** Supabase Auth (JWT Auth Filter & OTP Verification)

---

## 📊 Day 30 Presentation Deck Structure (6 + 1 Slides)

The presentation deck (`lendly_day30_slides.html`) is structured into **6 core content slides + 1 closing slide**:

1. **Slide 1 — Title & Team:** LENDLY introduction, Day 30 Milestone, Team DevSync, Saveetha Engineering College (GIF 2026).
2. **Slide 2 — Overview & Problem:** Hyperlocal `< 5 km` concept, 6-module scope, and key barriers to local tool sharing.
3. **Slide 3 — Solution & Modules:** Task-based discovery, QR/photo logs, dynamic trust deposits, and secure UPI & analytics.
4. **Slide 4 — End-to-End Process:** Visual 5-step rental lifecycle from discovery to escrow release.
5. **Slide 5 — Tech Stack:** React & Vite, Java Spring Boot, PostgreSQL, and Supabase Auth.
6. **Slide 6 — System Logic & Day 30 Roadmap:** 100-point trust engine mechanics and Phase 01–04 execution progress.
7. **Slide 7 (+1) — Closing Slide:** Summary takeaway and Team DevSync credits.

---

## 🗺️ Execution Roadmap & Day 30 Log

* ✅ **Phase 01 — Core & Auth:** Supabase schema, JWT login filter, and task-based geo-search.
* ✅ **Phase 02 — Handover & UPI:** QR code check-out/return flow, photo condition logs, and UPI escrow engine.
* 🔄 **Phase 03 — Trust & Analytics (Day 30 Milestone):** Finalized 100-point reputation scoring, dispute workflow, analytics reporting, and 6+1 presentation deck.
* 🔜 **Phase 04 — Campus & Local Pilot:** Direct neighbor onboarding and Saveetha campus rollout.

---

## 🚀 Quick Local Setup

```bash
# 1. Start Backend (Java Spring Boot)
cd backend
./mvnw spring-boot:run

# 2. Start Frontend (React + Vite)
cd frontend
npm install
npm run dev
```

---

*Built with ❤️ by **Team DevSync** — Saveetha Engineering College · GIF 2026*