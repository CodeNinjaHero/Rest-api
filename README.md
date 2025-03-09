# 🛠️ Rest API - User Management

This is a **Spring Boot REST API** for user management. It includes **Swagger documentation**, CRUD operations, and supports **partial updates**.

## 📌 Features

- Full **CRUD** for users.
    
- **DTO-based** data handling.
    
- **Swagger UI** for API documentation.
    
- Supports **partial updates** (only modifies provided fields).
    
- Security is **disabled** for now.
    

## 🚀 Installation & Execution

### 1️⃣ **Clone the repository**

```
git clone https://github.com/CodeNinjaHero/Rest-api.git
```
```
cd user-api
```

### 2️⃣ **Set up the environment**

Ensure you have **Java 17+** and **Maven** installed.

### 3️⃣ **Run the API**

```
mvn spring-boot:run
```

The API will be available at `http://localhost:6969/api/`.

## 📚 API Endpoints

|Method|Endpoint|Description|
|---|---|---|
|GET|`/users`|Retrieve all users|
|GET|`/users/{id}`|Retrieve a user by ID|
|POST|`/users`|Create a new user|
|PUT|`/users/{id}`|Partially update a user|
|DELETE|`/users/{id}`|Delete a user|

## 📚 Use postman
👉 import the file `User-API.postman_collection.json` into Postman.

### Steps to import:
1. Open Postman.
2. Click on **File > Import**.
3. Select the `User-API.postman_collection.json` file.
4. Click **Import** to load the API collection.

## 📚 **Swagger Documentation**

Once the API is running, access the docs at:  
👉 `http://localhost:6969/api/swagger-ui.html`

## 🛠️ Tech Stack

- **Spring Boot**
    
- **Spring Web**
    
- **Spring Data JPA**
    
- **Lombok**
    
- **Swagger OpenAPI**
    
- **Maven**
    

## 📌 Contributing

1. **Fork** the repository.
    
2. Create a new branch (`git checkout -b feature-new-functionality`).
    
3. Make your changes and **commit** (`git commit -m "feat: add new functionality"`).
    
4. **Push** your changes (`git push origin feature-new-functionality`).
    
5. Open a **Pull Request**.
