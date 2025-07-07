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
- 💾 **MySQL Integration with Spring JPA**
- 🧱 **Modular Structure with MVC & DTO Layers**
- 🧪 **Swagger for API Testing & Documentation**

---

## 📁 Project Structure

![Image alt](https://github.com/Vivek0375/SHCMS/blob/9d5349fb37e34577a06aeebe4ab6162561020460/shcms-image/Screenshot%202025-07-07%20165439.png)

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

🖼️ # ** Screenshots to Include**
Upload these in a screenshots/ folder and embed in README:

 Swagger interface for testing:
 ![Image alt](https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20212819.png)

login_page data :
![Image alt](https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20212819.png)


appointment_booking_data:
![Image alt](https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20195645.png)


▶️ # **Run Locally**
bash
Copy
Edit
# 1. Clone Repo
git clone https://github.com/Vivek0375/SHCMS.git
cd SHCMS

# 2. Configure application.properties or environment variables

# 3. Build and Run
mvn clean install
java -jar deploy/application.jar

# App runs at: http://localhost:8080

🌍 # ** Deployment**
Deployed using AWS EC2 instance:

![Image alt]([https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20195645.png](https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20192828.png))

Java JDK 17 installed

JAR file running as background process (e.g., via screen, nohup, or systemd)

Security Groups configured for HTTP (port 8080 or 80)

MySQL hosted on RDS or same instance
![Image alt](https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20195726.png)

🧠 # Future Enhancements

📈 Analytics for Disease Trends & Doctor Activity

📬 Email Notifications for Appointments

# Working on postmant After deployment:
![Image alt](https://github.com/Vivek0375/SHCMS/blob/f96287b805187cc48c14e37b02cc3365bbf7b69b/shcms-image/Screenshot%202025-07-06%20164110.png)

🧑‍💻 # **Author**
Vivek Yadav
Connect with me on LinkedIn for any contributions, questions, or concerns using link -> www.linkedin.com/in/vivekyadav375
GitHub: @Vivek0375

📜 # **License**
This project is licensed under the MIT License.



