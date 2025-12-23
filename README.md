# 🌐 Web-Based Windows OS Dashboard

<p align="center">
  <img src="https://github.com/user-attachments/assets/278720d3-80af-4af1-9e30-c0f393631277" width="911" alt="Project Dashboard Screenshot">
</p>

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

