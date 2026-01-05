🚀 ATC Tourism Backend (Spring Boot + MySQL)
📌 Overview
<img width="1345" height="606" alt="Screenshot 2026-01-01 210650" src="https://github.com/user-attachments/assets/8c33bacb-3533-41b6-89e6-d5e258273ead" />

This backend project powers the ATC Tourism Application, providing REST APIs for managing:

Tourism packages

Users

Bookings

Reviews

Image uploads

It is built using Spring Boot, MySQL, JPA & Maven and runs as an independent backend server.

<img width="1346" height="598" alt="Screenshot 2026-01-01 210903" src="https://github.com/user-attachments/assets/5b0740f2-2c37-4624-841b-f062dbf18986" />
```bash
USERNAME:admin
PASSWORD:admin 
```
<img width="1362" height="596" alt="Screenshot 2026-01-01 210925" src="https://github.com/user-attachments/assets/b2b282ef-3035-4603-beea-bd4907a7c2d5" />

<img width="1361" height="596" alt="Screenshot 2026-01-01 210935" src="https://github.com/user-attachments/assets/1891edf6-add8-402b-97e8-e51f1c08b286" />

<img width="1350" height="600" alt="Screenshot 2026-01-01 210803" src="https://github.com/user-attachments/assets/7d413a9d-c6c1-4e38-8927-ac043f519294" />


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


🌐 Live Project Links

🚀 Frontend (Vercel – Live UI)
🔗 https://atc-tourism-frontend.vercel.app/

🛠️ Backend API (Render)
🔗 https://aja-tourism-corporation.onrender.com/

🗄️ Database (Railway – PostgreSQL/MySQL)
🔗 https://railway.com/project/568ac9ce-6763-4fe5-ac59-672eff7818a2?environmentId=47855gf-gfhh7-g4

🔗 Full Stack Architecture
```bash
User (Browser)
   ↓
Frontend (React + Vite) – Vercel
   ↓ REST API
Backend (Spring Boot / Node) – Render
   ↓
Database (Railway Cloud DB)
```
🤝 Author

Manish Maharana
Java Intern – Coding Tutor, Hyderabad

📧 Email: manishmaharana91@gmail.com

💻 GitHub: https://github.com/mrmanishgit

⭐ Support

If this project helped you, please star this repo on GitHub ⭐🙂
