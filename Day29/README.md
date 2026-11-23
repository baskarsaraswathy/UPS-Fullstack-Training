# 📅 Day 29: Project Lendly — Presentation & Pitch Preparation

**Project:** Lendly (Hyper-Local Peer-to-Peer Neighborhood Rental Platform)  
**Team:** Team DevSync (Baskar J, Iyalarasu C, Dharmalingam S)  
**Event:** Saveetha Engineering College · GIF 2026  

---

## 📌 Daily Summary
Today's focus was organizing, structuring, and rehearsing the 7–10 minute pitch deck for **Project Lendly**. We finalized speaker allocations across the 8-slide deck, aligned transitions between team members, and prepared technical talking points and Q&A responses for the staff review panel.

---

## 📊 Presentation Deck Breakdown

| Slide(s) | Topic | Presenter | Core Focus |
| :--- | :--- | :--- | :--- |
| **Slide 1–2** | Problem Statement & Solution | Teammate | Cost of owning rarely used household/DIY tools vs. hyper-local neighborhood sharing. |
| **Slide 3–4** | Core Modules & Rental Workflow | Teammate | Task-based bundle search, direct peer-to-peer handovers (no middleman hubs), and booking lifecycle. |
| **Slide 5** | Trust, Safety & Escrow System | **Baskar J** | QR-verified pickup/return scans, timestamped before/after condition logs, and dynamic trust-based security deposits held in escrow. |
| **Slide 6** | System Architecture & Tech Stack | **Baskar J** | **Frontend:** React · **Backend:** Spring Boot (REST APIs + JWT) · **Database & Storage:** Supabase (PostgreSQL + Storage buckets). |
| **Slide 7** | Technical Design & Database Schema | **Baskar J** | Normalized PostgreSQL tables (`Users`, `Items`, `Bundles`, `Bookings`, `Escrow_Transactions`, `Handover_Logs`), overlap prevention, and RLS policies. |
| **Slide 8** | Execution Roadmap & Overview | All | MVP implementation timeline, neighborhood rollout strategy, and final closing summary. |

---

## 🎤 Key Technical Highlights Covered (Slides 5–7)

* **Escrow State Machine:** Funds (rental fee + dynamic deposit) are locked prior to handover and released to the lender only after mutual QR return scanning and condition verification.
* **Zero-Hub Verification:** Dual-party QR codes paired with immutable before-and-after inspection photos stored in Supabase Storage eliminate the need for physical pickup centers.
* **Full-Stack Security & Integrity:** Spring Boot handles JWT authentication, transactional double-booking prevention, and business logic, backed by Supabase PostgreSQL.

---

## ✅ Action Items Completed
- [x] Finalized 8-slide deck flow and speaker handoffs.
- [x] Outlined technical talking points for Trust/Escrow, Architecture, and DB Schema.
- [x] Prepared defense points for staff Q&A (payment escrow vs. direct UPI, double-booking prevention, and dispute resolution).
- [ ] Conduct final timed 8-minute team dry run before the review session.