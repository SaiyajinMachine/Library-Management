# 📚 Library Inventory Management Web App

## 📝 Project Overview

Welcome to **Library Inventory Management Web App**, a fullstack, end-to-end Maven web application developed in Java. The project employs traditional Spring and Hibernate for the backend, while the frontend is crafted using Thymeleaf, HTML, and CSS with Bootstrap. This application allows you to manage an inventory of books, including viewing a list, and managing individual books (add, edit, delete). It also exposes a RESTful API for CRUD operations on the library inventory through the `/api/` endpoint. The application is deployed in Docker.

This project showcases a comprehensive approach to handling book inventories with modern web technologies and containerization.

## 🚀 Technologies Used

- **Java**: The primary programming language for backend development.
- **Maven**: Build automation tool used to manage project dependencies.
- **Spring**: Framework used for building the backend services.
- **Hibernate**: ORM framework for database interaction.
- **MySQL**: Relational database used to store book inventory data.
- **HTML**: Markup language for structuring the web content.
- **CSS**: Stylesheet language for designing the application.
- **Thymeleaf**: Server-side template engine for rendering views.
- **IntelliJ IDEA**: IDE used for development.
- **Docker**: Containerization platform for deploying the application.
- **Bootstrap**: Framework for designing responsive and modern UI.
---
## 🚀 How to Run

To run this project locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/SaiyajinMachine/Library-Management.git
   ```
2. Go into the cloned directory:
   ```bash
   cd LibraryInventory
   ```
3. Make sure you have Docker and Maven installed.
4. Inside the directory, run:
   ```bash
   docker-compose up --build
   ```
5. Make sure the built Docker container is running.
6. In your web browser go to the URL http://localhost:8080/library/
7. (Optional) If you make changes in the code, run these commands to rebuild the project in Docker:
   ```bash
   docker-compose down -v
   ```
   ```bash
   docker-compose up --build
   ```
   
## 📡 RESTful API Endpoints and Request Methods
- **GET** `/api/books` - Retrieve a list of all books.
- **GET** `/api/books/<id>` - Retrieve details of a specific book by ID.
- **POST** `/api/books` - Add a new book.
- **PUT** `/api/books/<id>` - Update an existing book by ID.
- **DELETE** `/api/books/<id>` - Delete a book by ID.

<img src="https://media.tenor.com/MtJdP2cF4dEAAAAC/book.gif" style="width: 50%;" />
