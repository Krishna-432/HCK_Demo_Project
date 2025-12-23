# 🌐 Web-Based Windows OS Dashboard

A sophisticated full-stack web application that recreates a Windows Desktop experience within a browser. This project integrates deep system-level file access with modern web security practices, allowing users to interact with their local machine drives through a web interface.

## 🚀 Key Features

* **Interactive Desktop:** Glassmorphism UI with clickable icon-buttons for "This PC", "Recycle Bin", and web browsers.
* **Local File Explorer:** Real-time navigation of the host machine's local file system (C:, D:, etc.).
* **File Operations:** Explore directories, download files directly to the browser, and "Recycle" local files.
* **Functional Recycle Bin:** Logic to move files to a secure application bin and **Restore** them to their original system paths.
* **Secure Authentication:** * User Registration with Password Strength Validation.
    * Spring Security 6 protected routes.
    * **Password Reset:** Gmail SMTP integration for secure reset token delivery via email.

## 🛠️ Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Backend** | Java 21, Spring Boot 3.4.1 |
| **Security** | Spring Security 6 (BCrypt Encryption) |
| **Database** | MySQL 8.0 |
| **Frontend** | Thymeleaf, HTML5, CSS3 (Glassmorphism), Vanilla JS |
| **Mail** | Spring Boot Starter Mail (SMTP Integration) |



## ⚙️ Setup & Installation

### 1. Prerequisites
* Java 21 JDK installed.
* MySQL Server running.
* **IDE (Eclipse/IntelliJ) running as Administrator** (Required for local Drive access).

### 2. Database Setup
```sql
CREATE DATABASE hck_project_demo;


3. Application Configuration
Update src/main/resources/application.properties with your database and Gmail SMTP credentials as shown below:

<p align="center"> <img src="https://github.com/user-attachments/assets/73ff50f1-e681-41cd-b0eb-f765474d8c46" width="850" alt="Application Properties Configuration"> </p>

📂 Project Structure
src/main/java/com/example/hckdemo/
├── config/         # Security (Spring Security) & App Configuration
├── controller/     # Auth, Dashboard & System File REST Controllers
├── model/          # User Entities (MySQL Table Mapping)
├── repository/     # JPA Data Access layer
└── service/        # Business Logic & Email Service
