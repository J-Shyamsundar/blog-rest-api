# 📝 Blog REST API

A backend REST API for a Blogging platform built with **Java**, **Spring Boot**, and **MySQL**.

---

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security + JWT Authentication**
- **Spring Data JPA + Hibernate**
- **MySQL**
- **Lombok**
- **Maven**

---

## ✨ Features

- 🔐 JWT-based Authentication (Register & Login)
- 👥 Role-based Access Control (ADMIN / USER)
- 🔒 Method-level Security with **@PreAuthorize**
- 📝 Post Management (CRUD)
- 💬 Comment Management
- ⚠️ Custom Exception Handling
- 🏗️ Layered Architecture (Controller → Service → Repository)

---

## 🔑 API Endpoints

### Auth
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/auth/register` | Public |
| POST | `/auth/login` | Public |

### Posts
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/posts` | Authenticated |
| GET | `/posts` | Public |
| GET | `/posts/{id}` | Public |
| PUT | `/posts/{id}` | Authenticated |
| DELETE | `/posts/{id}` | ADMIN only |

### Comments
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/comments` | Authenticated |
| GET | `/comments?postId=1` | Public |
| DELETE | `/comments/{id}` | ADMIN only |

---

## ⚙️ How to Run

**1. Clone the repo**
```bash
git clone https://github.com/J-Shyamsundar/blog-rest-api.git
```

**2. Create MySQL database**
```sql
CREATE DATABASE blog_db;
```

**3. Configure `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=your_username
spring.datasource.password=your_password
app.jwt.secret=your_secret_key
app.jwt.expiration=86400000
```

**4. Run**
```bash
mvn spring-boot:run
```

---

## 🔐 Authentication
Authorization: Bearer <your_token>

---

---

## 👨‍💻 Author

**J.Shyam Sundar** — [LinkedIn](https://www.linkedin.com/in/shyamsundar29) | [GitHub](https://github.com/J-Shyamsundar)
