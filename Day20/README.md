# Day 20 – NeighborRent

## Topics Discussed
- Project wireframe discussion
- Project documentation discussion
- Review of the problem statement, proposed solution, enhanced features, and user workflow
- Confirmation of the project technology stack

## Project Overview
**Project Name:** NeighborRent  
**Tagline:** Rent • Share • Reuse Locally

NeighborRent is a neighborhood-based rental platform that helps people rent tools and equipment from verified nearby users. It focuses on task-based discovery, safer handovers, transparent deposits, and trust between owners and renters.

## Problem Statement
- Costly items such as drills, ladders, projectors, and pressure washers often remain unused.
- People may need these items for only a few hours and cannot justify purchasing them.
- Existing rental platforms can have trust, damage, theft, pickup, and item-discovery challenges.
- Owners may hesitate to list items because they fear loss or damage.

## Proposed Solution
A neighborhood-based rental application where users can search by task, rent from verified neighbors, and complete item handovers using QR scans and photo checks. Booking, deposits, payments, and ratings are managed through the application.

## Enhanced Features
| Challenge | Proposed enhancement |
|---|---|
| Users do not know which item they need | Task-based bundle search, such as “hang shelves” recommending a drill, ladder, and level |
| Fear of item damage | QR handover and before/after photo comparison, with AI-assisted damage detection planned |
| Unfair fixed deposits | Trust-score-based deposit calculation |
| Owners bear all the risk | Damage protection pool funded by a small rental fee |
| Meeting strangers | Community pickup points such as shops and apartment lobbies |
| Low item availability | Neighborhood-first launch in campuses, colonies, and apartment communities |
| Owners are unsure about pricing | Smart price suggestions and demand insights |
| Language barriers | Voice-assisted and regional-language listings, with UPI payment support |

## How It Works
1. The owner lists an item with its rental price and availability.
2. The renter searches by task, selects an item or bundle, and pays the rent and refundable deposit.
3. At pickup, both users scan the QR code and capture photos of the item's condition.
4. At return, the QR code is scanned again and the condition photos are compared.
5. If no damage is detected, the deposit is released. If damage is reported, the owner can submit a claim for review under the deposit/protection process.
6. Both users rate each other, and their trust scores are updated.

## Confirmed Technology Stack
| Layer | Technology |
|---|---|
| Frontend | React, JavaScript, Vite, CSS |
| Backend | Java, Spring Boot |
| Database | PostgreSQL (Supabase) |
| Authentication | Supabase Auth, JWT |

## Wireframe Discussion
The renter-side wireframe discussion covered these screens:
1. Splash / Welcome
2. Home and task-based search
3. Recommended task bundle
4. Item details and owner information
5. Booking and payment
6. QR pickup handover
7. Item condition photo capture
8. My Rentals
9. Return and condition check
10. Rating and trust-score update

Suggested bottom navigation:
- Home
- My Rentals
- List Item
- Profile

## Documentation Discussion
The project documentation should include:
- Project abstract
- Problem statement
- Existing system and its limitations
- Proposed system
- Objectives and scope
- Functional and non-functional requirements
- User roles and use cases
- System architecture
- Technology stack
- Database design / ER diagram
- UI wireframes
- Module descriptions
- Testing approach
- Future enhancements

## Day 20 Outcome
Discussed and reviewed the NeighborRent wireframe and project documentation structure. Confirmed the initial technology stack and documented the core user flow and proposed enhancements.

## Note
AI photo comparison, QR verification, dynamic deposits, protection-pool handling, and payment processing are planned application capabilities. They will need to be designed, implemented, and tested as separate modules/integrations.
