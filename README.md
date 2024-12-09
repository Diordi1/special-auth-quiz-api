# Spring Boot Project with Spring Security, JWT, and Filters

This project is a boilerplate for building secure REST APIs using **Spring Boot**, **Spring Security**, **JWT (JSON Web Tokens)**, and custom **filters**. It provides features like user authentication, role-based authorization, and request validation.

---

## Features

1. **Spring Security Integration**
   - Role-based authentication and authorization.
   - Password encryption using **BCrypt**.

2. **JWT Implementation**
   - Secure token generation and validation.
   - Stateless authentication mechanism.
   - Token expiration and refresh logic.

3. **Custom Filters**
   - Pre-authorization filters for logging and request validation.
   - Post-authorization filters for modifying the response.

4. **Modular Architecture**
   - Easily extendable for different roles and user types.
   - Separation of concerns using layered architecture (Controller, Service, Repository).

---

## Tech Stack

- **Spring Boot** (Core Framework)
- **Spring Security** (Authentication and Authorization)
- **JWT** (Stateless Authentication)
- **Hibernate/JPA** (Database Access)
- **MySQL/PostgreSQL** (Database)
- **Maven** (Build Tool)

---

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
- MySQL/PostgreSQL database
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Steps to Run the Application

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/spring-boot-security-jwt.git
   cd spring-boot-security-jwt
2.Set Up the Database

Create a database and update the credentials in application.yml:
yaml
spring.datasource.url="jdbc:h2:mem:testdb"

3.Build the Application
mvn clean install

4.Run the Application
mvn spring-boot:run
  
