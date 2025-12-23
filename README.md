# 🌐 Web-Based Windows OS Dashboard

A sophisticated full-stack web application that recreates a Windows Desktop experience within a browser. This project integrates deep system-level file access with modern web security practices.

## 🚀 Key Features

* **Interactive Desktop:** Glassmorphism UI with clickable icon-buttons for "This PC", "Recycle Bin", and web browsers.
* **Local File Explorer:** Real-time navigation of the host machine's local file system (C:, D:, etc.).
* **File Operations:** Explore directories, download files directly to the browser, and "Recycle" local files.
* **Functional Recycle Bin:** Logic to move files to a secure application bin and **Restore** them to their original system paths.
* **Secure Authentication:** * User Registration with Password Strength Validation.
    * Spring Security 6 protected routes.
    * **Password Reset:** Gmail SMTP integration for secure reset token delivery.

## 🛠️ Tech Stack

| Layer | Technology |
| :--- | :--- |
| **Backend** | Java 21, Spring Boot 3.4.1 |
| **Security** | Spring Security 6 (BCrypt Encryption) |
| **Database** | MySQL 8.0 |
| **Frontend** | Thymeleaf, HTML5, CSS3 (Glassmorphism), Vanilla JS |
| **Mail** | Spring Boot Starter Mail (SMTP) |



## ⚙️ Setup & Installation

### 1. Prerequisites
* Java 21 JDK.
* MySQL Server.
* **IDE (Eclipse/IntelliJ) running as Administrator** (Required for Drive access).

### 2. Database Setup
```sql
CREATE DATABASE hck_project_demo;

<img width="865" height="427" alt="image" src="https://github.com/user-attachments/assets/265bc8d0-56af-4b90-ba75-2634b3e04b8a" />

<img width="911" height="493" alt="image" src="https://github.com/user-attachments/assets/278720d3-80af-4af1-9e30-c0f393631277" />

Developed by Krishna-432


---

### 📤 How to save and push this:
1.  Open your `README.md` file in your project folder.
2.  **Paste** the content above and **Save**.
3.  Run these commands in your terminal:
    ```powershell
    git add README.md
    git commit -m "Finalized README with project details"
    git push origin main
    ```

**Would you like me to help you add a "Screenshot" section to the README once you have the app running?**
