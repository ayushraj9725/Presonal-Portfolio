# 💼 Ayush Raj - Portfolio Website

Welcome to my personal developer portfolio website built using **HTML, CSS, JavaScript, and Spring Boot**. This project showcases my work, technical skills, and includes a fully functional **contact form** with backend storage.

> 🔗 Live Demo: [https://your-portfolio-link.com](https://your-portfolio-link.com)  
> 📬 Admin Panel: Private (Only for personal use)  

---

## 🧾 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Frontend Structure](#frontend-structure)
- [Backend Structure](#backend-structure)
- [Running Locally](#running-locally)
- [Deployment](#deployment)
- [Screenshots](#screenshots)
- [License](#license)

---

## 📌 About the Project

This is a **responsive developer portfolio** that includes sections such as:

- 🏠 Home  
- 👤 About  
- 🛠️ Skills (scrolling animation)  
- 📂 Projects  
- ✉️ Contact (with backend integration)

The contact form is connected to a **Spring Boot** backend API that stores messages in a database. As the admin, I can view/delete messages through a secure dashboard.

---

## ✨ Features

- Responsive design with smooth animations  
- Dynamic scrolling skill section with infinite horizontal animation  
- Backend API to handle message storage  
- Admin dashboard to view and delete messages  
- Full RESTful API integration using `fetch()`  
- CORS configured for cross-origin communication  

---

## 🛠️ Tech Stack

### 🖥️ Frontend
- HTML5
- CSS3 (with animations)
- JavaScript (Vanilla)
- Bootstrap 5

### 🌐 Backend
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (can be changed to PostgreSQL or H2)
- Maven / Gradle

---

## 🧩 Frontend Structure

![here the structure ](https://github.com/ayushraj9725/Presonal-Portfolio/blob/master/ayush-porfolio/frontendstu.png)

---

## ⚙️ Backend Structure (Spring Boot)

![here the structure ](https://github.com/ayushraj9725/Presonal-Portfolio/blob/master/ayush-porfolio/backendstu.png)


---

## 🚀 Running Locally

### 1. Clone the repo

```bash
git clone https://github.com/ayushraj9725/Presonal-Portfolio.git
cd portfolio

```

### 2. Run Backend (Spring Boot)

```bash
cd portfolio-backend
./gradlew bootRun
```

Default port: http://localhost:7979

### 3. Open Frontend
Open index.html or admin.html using Live Server or any static file server.

☁️ Deployment
Frontend: Netlify / GitHub Pages / Vercel
Backend: Render / Railway / Heroku / VPS

Make sure to update the API base URL in your JS files:

```bash

const API_BASE = "https://your-backend-url/api/v1";

```
*** You can see here some Screensorts ***

![portfolio](https://github.com/ayushraj9725/Presonal-Portfolio/blob/master/ayush-porfolio/portfolio.png)
![Skill Banner](https://github.com/ayushraj9725/Presonal-Portfolio/blob/master/ayush-porfolio/skillbanner.png)
![Form Banner](https://github.com/ayushraj9725/Presonal-Portfolio/blob/master/ayush-porfolio/formbanner.png)
![Admin Banner](https://github.com/ayushraj9725/Presonal-Portfolio/blob/master/ayush-porfolio/adminbanner.png)




