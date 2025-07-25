# 📓 Journal App - Spring Boot REST API
This is a **backend journal application** built using **Spring Boot**. It provides a simple API to perform CRUD (Create, Read, Update, Delete) operations on journal entries.

---

## 📓 About the Project

The Journal App allows users to:

- Add journal entries
- View all entries or a specific entry by ID
- Update entries (fully or partially)
- Delete entries

The app uses a **relational database (e.g., MySQL)** and follows RESTful principles.

---

## 🛠️ Technologies Used

| Tool/Tech               | Purpose                             |
|------------------------|-------------------------------------|
| Java 17+               | Programming language                |
| Spring Boot            | Backend Framework                   |
| Spring Data JPA        | ORM & Repository layer              |
| MySQL                  | Relational Database                 |
| Hibernate              | JPA implementation                  |
| Lombok                 | Reduces boilerplate code            |
| ModelMapper            | DTO to Entity mapping               |
| Postman                | API testing                         |
| Git & GitHub           | Version control & hosting           |
| IntelliJ IDEA          | Development environment             |

---

## ✨ Features

- ✅ Create new journal entries (`POST /api/journals`)
- ✅ Get all journal entries (`GET /api/journals`)
- ✅ Get a journal entry by ID (`GET /api/journals/{id}`)
- ✅ Update journal entry fully (`PUT /api/journals/{id}`)
- ✅ Partially update entry (`PATCH /api/journals/{id}`)
- ✅ Delete a journal entry (`DELETE /api/journals/{id}`)
- ✅ Timestamps handled using `@CreationTimestamp` & `@UpdateTimestamp`
- ✅ Error handling with meaningful responses
- ✅ DTO layer to separate Entity and API layers

---

## 📦 API Endpoints

| Method | Endpoint                  | Description                      |
|--------|---------------------------|----------------------------------|
| POST   | `/api/journals`           | Create new journal               |
| GET    | `/api/journals`           | Get all journals                 |
| GET    | `/api/journals/{id}`      | Get journal by ID                |
| PUT    | `/api/journals/{id}`      | Full update of journal           |
| PATCH  | `/api/journals/{id}`      | Partial update (using Map)       |
| DELETE | `/api/journals/{id}`      | Delete journal by ID             |

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/journal-app.git
cd journal-app
