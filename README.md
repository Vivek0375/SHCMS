# 🏥 Smart Health Consultation & Medical Record System (SHCMS)

A full-stack Java Spring Boot-based web application designed to simplify patient-doctor interactions, streamline medical recordkeeping, and support secure health consultations in both rural and urban settings.

## 📌 Overview

Modernizing healthcare delivery is essential for better accessibility and reliability. SHCMS addresses this need by offering a centralized portal for:

- Booking and managing appointments
- Uploading and accessing medical records (PDFs/Images)
- Role-based access control (Patients, Doctors, Admin)
- Secure authentication using JWT
- Dashboard and analytics (ongoing)

> ✅ Built with Java 17, Spring Boot, Spring Security, MySQL, JWT, Lombok

---

## 🎯 Problem Statement

In many healthcare environments, especially semi-urban or rural clinics:

- Records are still paper-based or inconsistently stored.
- Patients forget medical history between visits.
- Doctors lack centralized access to previous consultations.
- Secure communication and data handling are absent.

**SHCMS** bridges these gaps using digital tools and robust backend architecture.

---

## ✅ Core Features

- 🔐 **Secure Login & JWT Authentication**
- 🧑‍⚕️ **Role-Based Access (Doctor, Patient, Admin)**
- 📅 **Appointment Scheduling with Status Updates**
- 📂 **Medical Record Uploading (Image/PDF)**
- 🗂️ **Database-Backed Patient History**
- 📊 **Dashboard & Analytics Module** *(Coming Soon)*
- 💾 **MySQL Integration with Spring JPA**
- 🧱 **Modular Structure with MVC & DTO Layers**
- 🧪 **Swagger for API Testing & Documentation**

---

## 📁 Project Structure

SHCMS/
│
├── src/
│ ├── main/java/com/vivek/shcms/
│ │ ├── controller/
│ │ ├── dto/
│ │ ├── entity/
│ │ ├── repository/
│ │ ├── security/
│ │ ├── service/
│ │ └── ShcmsApplication.java
│ └── resources/
│ ├── application.properties
│ └── static/
├── deploy/
│ ├── application.jar
│ └── deploy.zip
├── .gitignore
└── pom.xml


---

## 🚀 Tech Stack

| Layer         | Technology              |
|---------------|--------------------------|
| Backend       | Java 17, Spring Boot     |
| Security      | Spring Security, JWT     |
| Database      | MySQL, JPA               |
| API Docs      | Swagger (OpenAPI)        |
| Deployment    | AWS EC2 (JAR based)      |
| Dev Tools     | Lombok, Maven            |

---

## 🔒 Sensitive Data Handling

**Environment Variables:**
- All credentials (DB, JWT secret, file paths) are stored using environment variables or an `.env` file (not pushed to GitHub).
- `application.properties` reads values via `${ENV_VAR}` notation.

Example:
```properties
spring.datasource.url=${DB_URL}
jwt.secret=${JWT_SECRET}

API Testing with Swagger
Run the app and visit:
bash
Copy
Edit
_http://localhost:8080/swagger-ui/index.html_
You can use Swagger UI to test authentication, appointments, records, and user roles.

🖼️ Screenshots to Include
Upload these in a screenshots/ folder and embed in README:

login_page.png – Login interface

dashboard_doctor.png – Doctor's dashboard view

patient_record_upload.png – Uploading medical record

appointment_booking.png – Booking UI

swagger_apis.png – Swagger interface for testing


