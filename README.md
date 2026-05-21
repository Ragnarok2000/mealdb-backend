The frontend fetches data from http://localhost:8081/api/meals/....
---

## 🔹 Backend (`mealdb-backend/README.md`)
```markdown
# MealDB Explorer - Backend

This is the **Spring Boot backend** for TheMealDB Explorer.  
It fetches data from the public [TheMealDB API](https://www.themealdb.com/api.php) and exposes simplified REST endpoints for the frontend.

## 🚀 Features
- RESTful API endpoints
- In‑memory caching with expiry
- CORS enabled for frontend connection
- Runs locally on port **8081**

## 📦 Setup
```bash
# Build project
mvn clean install

# Run backend
mvn spring-boot:run

Backend runs on: http://localhost:8081

🔗 API Endpoints
GET /api/meals/search?name={mealName}

GET /api/meals/random

GET /api/meals/category/{category}

GET /api/meals/{id}
