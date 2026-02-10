A.Project Overview
This project is a Spring Boot REST API designed to manage traffic accident data together with sensor information. The system supports full CRUD operations and follows clean architectural principles.

B. REST API Documentation
The API provides endpoints to create, retrieve, update, and delete accident records using standard HTTP methods. All endpoints were tested using Postman and return JSON responses.

C. Design Patterns Section
The Singleton pattern is used to manage shared application configuration, the Factory pattern is used to create accident objects dynamically, and the Builder pattern is used to construct complex sensor data objects.

D. Component Principles Section
The application is structured into controller, service, and repository layers to ensure separation of concerns and low coupling between components.

E. SOLID & OOP Summary
The project follows SOLID principles by ensuring single responsibility, extensibility, and dependency inversion. Core OOP concepts such as abstraction, inheritance, polymorphism, and composition are applied throughout the codebase.

F. Database Schema
The database schema consists of related tables for accident events and sensor data connected via foreign keys. SQL scripts are used to initialize and populate the database.

G. System Architecture Diagram
The system follows a layered architecture where requests flow from the controller to the service and repository layers. A UML diagram illustrating this structure is included in the project documentation.

H. Instructions to Run the Spring Boot Application
The application can be started by configuring the database connection and running the main Spring Boot class. Once started, the API is available on a local server and can be tested using Postman.

I. Reflection Section
This project improved my understanding of RESTful API development, Spring Boot architecture, and design patterns. I gained practical experience in structuring backend applications and working with relational databases.
