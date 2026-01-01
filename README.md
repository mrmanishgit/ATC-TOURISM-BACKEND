🚀 ATC Tourism Backend (Spring Boot + MySQL)
📌 Overview

This backend project powers the ATC Tourism Application, providing REST APIs for managing:

Tourism packages

Users

Bookings

Reviews

Image uploads

It is built using Spring Boot, MySQL, JPA & Maven and runs as an independent backend server.

🛠️ Tech Stack
```bash
Technology	Purpose
Spring Boot	Backend framework
Spring MVC	REST API handling
Spring Data JPA	Database ORM
MySQL	Database
Lombok	Reduces boilerplate code
Maven	Build & dependency management
```
⚙️ Installation & Setup
1️⃣ Clone the repository
```bash
git clone https://github.com/mrmanishgit/ATC-TOURISM-BACKEND.git
cd ATC-TOURISM-BACKEND
```
2️⃣ Update database configuration
```bash
In src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/aja_tourism
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
▶️ Run the Project
Run with Maven
```bash
mvn spring-boot:run
```
Build JAR
mvn clean package
```bash
java -jar target/AjaTourismCorporation-0.0.1-SNAPSHOT.jar
```
🌍 Default Server URL
```bash
http://localhost:8080
```
❗If 8080 is busy, change port:
server.port=8081

📁 Folder Structure
```bash
ATC-TOURISM-BACKEND/
├── src/
│   ├── main/java/com/aja/
│   │       └── AjaTourismCorporationApplication.java
│   ├── main/resources/
│   │       ├── application.properties
│   │       └── static/uploads/
├── pom.xml
└── README.md
```
🧩 API Testing (Optional)

Use Postman / Thunder Client / Browser to test API endpoints.

Example test:

GET http://localhost:8080/api/packages

📌 Common Issues & Fixes
Issue	Fix
Port 8080 already in use	Stop process or set server.port=9090
Database connection error	Check MySQL username & password
App fails to start	Ensure JDK 21 installed & JAVA_HOME set
🤝 Author

Manish Maharana
Java Intern – Coding Tutor, Hyderabad

📧 Email: manishmaharana91@gmail.com

💻 GitHub: https://github.com/mrmanishgit

⭐ Support

If this project helped you, please star this repo on GitHub ⭐🙂
