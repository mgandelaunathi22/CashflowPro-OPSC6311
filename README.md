Cashflow Pro

Personal Budget Tracker App  
OPSC6311 POE Part 2 - Group Assignment

Group Members
- Unathi Mgandela – ST10447100
- Clarity Masuku – ST10438928
- Sibusiso Mabena – ST10462532

Project Description
Cashflow Pro is a user-friendly Android budgeting application that helps users track expenses, manage categories, set budgets, and attach receipt photos. 

The app follows the Research → Plan → Design → Build cycle as required in the module.

Features Implemented (Part 2 - Prototype)
- User Registration and Login
- CRUD operations for Categories (Digital Envelopes)
- Add Expense with amount, date, description, category, and receipt photo
- View expense list with date filtering
- View total spent per category
- Local data persistence using **Room Database**
- Clean backend architecture (Entities, DAOs, Repositories)

Tech Stack
- Kotlin
- Jetpack Compose / Views (depending on your choice)
- Room Database (SQLite)
- Coroutines + Flow

How to Run
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run on emulator or physical device

Backend Structure (Data Layer)
- `data/local/entity/` → Entities (User, Category, Expense, Budget)
- `data/local/dao/` → DAOs
- `data/local/` → AppDatabase + Converters
- `data/repository/` → Repository pattern



**Work in Progress** – More features (graphs, gamification) will be added in Part 3 (Final POE).
